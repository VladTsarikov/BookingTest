package booking.carsRental.enums;

public enum RentalSortCriteria {

    RECOMMENDED("recommended"),
    PRICE("price");

    private String sortType;

    RentalSortCriteria(String sortType) {
        this.sortType = sortType;
    }

    public String getSortType() {
        return sortType;
    }
}