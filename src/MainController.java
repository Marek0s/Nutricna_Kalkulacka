import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML private ComboBox<String> cbPohlavie;
    @FXML private TextField        tfVek;
    @FXML private ComboBox<String> cbAktivita;
    @FXML private Label            lblOsobaInfo;

    @FXML private TableView<Jedlo>           tvKatalog;
    @FXML private TableColumn<Jedlo, String> colNazov;
    @FXML private TableColumn<Jedlo, Double> colKcal;
    @FXML private TableColumn<Jedlo, Double> colB;
    @FXML private TableColumn<Jedlo, Double> colT;
    @FXML private TableColumn<Jedlo, Double> colS;

    @FXML private ListView<Jedlo> lvJedalnicek;
    @FXML private Button          btnPridat;
    @FXML private Button          btnHodnotit;

    @FXML private Label lblKcal;
    @FXML private Label lblBielkoviny;
    @FXML private Label lblTuky;
    @FXML private Label lblSacharidy;

    @FXML private TextArea taHodnotenie;

    private Osoba osoba = null;
    private Jedalnicek jedalnicek = new Jedalnicek();
    private final KatalogJedal katalog = new KatalogJedal();
    private final ObservableList<Jedlo> jedalnicekList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbPohlavie.setItems(FXCollections.observableArrayList("muz", "zena"));
        cbAktivita.setItems(FXCollections.observableArrayList("nizka", "stredna", "vysoka"));

        colNazov.setCellValueFactory(new PropertyValueFactory<>("nazov"));
        colKcal .setCellValueFactory(new PropertyValueFactory<>("kcal"));
        colB    .setCellValueFactory(new PropertyValueFactory<>("bielkoviny"));
        colT    .setCellValueFactory(new PropertyValueFactory<>("tuky"));
        colS    .setCellValueFactory(new PropertyValueFactory<>("uhlohydraty"));

        for (TableColumn<Jedlo, Double> col : new TableColumn[]{colKcal, colB, colT, colS}) {
            col.setCellFactory(tc -> new TableCell<>() {
                @Override
                protected void updateItem(Double val, boolean empty) {
                    super.updateItem(val, empty);
                    setText(empty || val == null ? null : String.format("%.1f", val));
                }
            });
        }

        tvKatalog.setItems(FXCollections.observableArrayList(katalog.getJedla()));

        lvJedalnicek.setItems(jedalnicekList);
        lvJedalnicek.setCellFactory(lv -> new ListCell<>() {
            @Override
            protected void updateItem(Jedlo item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null
                        ? null
                        : item.getNazov() + "  (" + String.format("%.0f", item.getKcal()) + " kcal)");
            }
        });

        btnPridat  .setDisable(true);
        btnHodnotit.setDisable(true);
    }

    @FXML
    private void onPotvrdit() {
        String pohlavie = cbPohlavie.getValue();
        String aktivita = cbAktivita.getValue();
        String vekStr   = tfVek.getText().trim();

        if (pohlavie == null || aktivita == null || vekStr.isEmpty()) {
            upozornenie("Vyplň všetky polia.");
            return;
        }
        try {
            int vek = Integer.parseInt(vekStr);
            osoba = new Osoba(pohlavie, vek, aktivita);
            lblOsobaInfo.setText(
                pohlavie + ", " + vek + " r., aktivita: " + aktivita
                + "  |  Ideál: " + Math.round(NutricnaKalkulacka.idealneKalorie(osoba)) + " kcal/deň"
            );
            btnPridat  .setDisable(false);
            btnHodnotit.setDisable(false);
            taHodnotenie.clear();
            aktualizujSuhrn();
        } catch (NumberFormatException e) {
            upozornenie("Vek musí byť celé číslo.");
        } catch (IllegalArgumentException e) {
            upozornenie(e.getMessage());
        }
    }

    @FXML
    private void onPridat() {
        Jedlo vybrane = tvKatalog.getSelectionModel().getSelectedItem();
        if (vybrane == null) { upozornenie("Vyber jedlo z katalógu."); return; }
        jedalnicek.pridajJedlo(vybrane);
        jedalnicekList.add(vybrane);
        aktualizujSuhrn();
        taHodnotenie.clear();
    }

    @FXML
    private void onOdstranit() {
        int idx = lvJedalnicek.getSelectionModel().getSelectedIndex();
        if (idx < 0) { upozornenie("Vyber jedlo na odstránenie."); return; }
        jedalnicekList.remove(idx);
        jedalnicek = new Jedalnicek();
        jedalnicekList.forEach(j -> jedalnicek.pridajJedlo(j));
        aktualizujSuhrn();
        taHodnotenie.clear();
    }

    @FXML
    private void onHodnotit() {
        if (osoba == null) { upozornenie("Najprv potvrď údaje o osobe."); return; }
        taHodnotenie.setText(NutricnaKalkulacka.ohodnotJedalnicek(jedalnicek, osoba));
    }

    private void aktualizujSuhrn() {
        lblKcal      .setText(String.format("%.1f kcal", jedalnicek.getSpoluKalorie()));
        lblBielkoviny.setText(String.format("%.1f g",    jedalnicek.getSpoluBielkoviny()));
        lblTuky      .setText(String.format("%.1f g",    jedalnicek.getSpoluTuky()));
        lblSacharidy .setText(String.format("%.1f g",    jedalnicek.getSpoluSacharidy()));
    }

    private void upozornenie(String sprava) {
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setHeaderText(null);
        a.setContentText(sprava);
        a.showAndWait();
    }
}
