package org.kalbeka;

/**
 * 3. Создать класс Park с внутренним классом, с помощью объектов которого можно хранить информацию
 * об аттракционах, времени их работы и стоимости.
 **/
class Park {
    org.kalbeka.Park.Attraction[] attractions = new org.kalbeka.Park.Attraction[3];

    void addAtraction() {
        this.attractions[0] = new org.kalbeka.Park.Attraction("Khali-Gali", "12.00-20.00", 19);
        this.attractions[1] = new org.kalbeka.Park.Attraction("Paratruper", "14.00-19.00", 15);
        this.attractions[2] = new org.kalbeka.Park.Attraction("Super-8", "13.00-20.00", 21);
    }

    class Attraction {
        String name;
        String time;
        int cost;

        Attraction(String name, String time, int cost) {
            this.name = name;
            this.time = time;
            this.cost = cost;
        }
    }
}
