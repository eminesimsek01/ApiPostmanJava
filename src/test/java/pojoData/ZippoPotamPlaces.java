package pojoData;

public class ZippoPotamPlaces {
      /*
        {
            "place name": "Maltepe Mah.",
            "longitude": "32.3609",
            "state": "İstanbul",
            "state abbreviation": "34",
            "latitude": "40.1589"
        }
     */

    /*
    Pojo Class Yöntemi POJO: Plain Old Java Object
    Expected data veya actual datayı depolamak yani tutmak için kullanıyoruz.
    Pojo oluşturmak için takip edilmesi gerekn basamaklar;
     */

    //1.Fieldlar ----> Var PRIVATE-----> Her bir json için
    //2.Parametresiz cons.
    //3.Parametreli cons.
    //4.Getter and Setter
    //5.toString

    private String placeName;
    private String longtitude;
    private String state;
    private String stateAbbreviation;
    private String latitude;

    public ZippoPotamPlaces() {
    }

    public ZippoPotamPlaces(String placeName, String longtitude, String state, String stateAbbreviation, String latitude) {
        this.placeName = placeName;
        this.longtitude = longtitude;
        this.state = state;
        this.stateAbbreviation = stateAbbreviation;
        this.latitude = latitude;
    }

}
