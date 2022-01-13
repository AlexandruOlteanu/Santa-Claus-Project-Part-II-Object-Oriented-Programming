package database;

import java.util.List;

public final class InitialData {

    private final List<Children> childrenList;

    private final List<SantaGift> santaGiftsList;

    public InitialData() {
        this.childrenList = null;
        this.santaGiftsList = null;
    }

    public InitialData(final List<Children> childrenList, final List<SantaGift> santaGiftsList) {
        this.childrenList = childrenList;
        this.santaGiftsList = santaGiftsList;
    }

    public List<Children> getChildrenList() {
        return childrenList;
    }

    public List<SantaGift> getSantaGiftsList() {
        return santaGiftsList;
    }

    @Override
    public String toString() {
        return "InitialData{"
                + "childrenList=" + childrenList
                + ", santaGiftsList=" + santaGiftsList
                + '}';
    }
}
