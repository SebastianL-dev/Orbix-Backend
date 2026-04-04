package co.edu.uptc.orbix_backend;

import co.edu.uptc.orbix_backend.model.Mission;
import co.edu.uptc.orbix_backend.service.MissionService;

public class Main {

  public static void main(String[] args) {   

    Mission ms = new Mission("Prueba", "Pruebas");
    MissionReposi
    MissionService mss = new MissionService(null);
    mss.saveMission(ms);
  }
}
