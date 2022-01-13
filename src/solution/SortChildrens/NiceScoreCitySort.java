package solution.SortChildrens;

import enums.Cities;
import solution.ChildrenCategory.ChildrenCategory;
import solution.City.City;
import java.util.ArrayList;
import java.util.List;

public final class NiceScoreCitySort implements SortChildren {

    /**
     * Sorteaza lista de copii In functie de nice score-ul oraselor.
     * Toate orasele sunt stocate corespunzator intr-o lista de obiecte
     * "City". Lista de copii este parcursa, identificandu-se pentru fiecare
     * orasul din care acesta face parte. In cele din urma se fac modificarile
     * corespunzatoare oraselor care sunt apoi sortate nice score si apoi
     * int ordine lexicografica. In final, copiii sunt sortati dupa ordinea
     * acestor orase si in caz de egalitate sunt ordonati dupa Id
     * @param childrenCategoryList Lista de copii ce trebuie sortata
     */
    @Override
    public void makeSort(final List<ChildrenCategory> childrenCategoryList) {
        List<City> cityList = new ArrayList<>();
        for (Cities city : Cities.values()) {
            if (city.equals(Cities.CLUJ)) {
                cityList.add(new City("CLUJ-NAPOCA"));
            } else {
                cityList.add(new City(city.toString()));
            }
        }

        for (ChildrenCategory children : childrenCategoryList) {
            for (City city :cityList) {
                if (children.getCity().toUpperCase().equals(city.getName())) {
                    city.add(children.getAverageScore());
                }
            }
        }

        for (City city :cityList) {
            city.solve();
        }

        cityList.sort((o1, o2) -> {
            if (Double.compare(o1.getNiceScoreCity(), o2.getNiceScoreCity()) == 0) {
                return o1.getName().compareTo(o2.getName());
            }
            return -Double.compare(o1.getNiceScoreCity(), o2.getNiceScoreCity());
        });

        childrenCategoryList.sort((o1, o2) -> {
            Integer position1 = 0, position2 = 0;
            for (int i = 0; i < cityList.size(); ++i) {
                City city = cityList.get(i);
                if (city.getName().equals(o1.getCity().toUpperCase())) {
                    position1 = i;
                }
                if (city.getName().equals(o2.getCity().toUpperCase())) {
                    position2 = i;
                }
            }
            if (position1.equals(position2)) {
                return o1.getId().compareTo(o2.getId());
            }
            return position1.compareTo(position2);
        });

    }
}
