package InterfacesAndAbstraction.lab.CarShopExtend;

import java.io.Serializable;

public interface Car extends Serializable {
    Integer TIRES = 4;
    String MODEL = null;
    String COLOR = null;
    int HORSE_POWER = 0;
    String COUNTRY_PRODUCED = null;

    String getModel();
    String getColor();
    Integer getHorsePower();
    String getCountryProduced();

}
