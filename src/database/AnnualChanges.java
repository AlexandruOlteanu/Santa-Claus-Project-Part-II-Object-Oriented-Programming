package database;

import java.util.List;

public final class AnnualChanges {

    private Integer newSantaBudget;

    private List<SantaGift> newGifts;

    private List<Children> newChildren;

    private List<ChildrenUpdate> childrenUpdates;
    private String strategy;

    public AnnualChanges() {
        this.newSantaBudget = null;
        this.newGifts = null;
        this.newChildren = null;
        this.childrenUpdates = null;
        this.strategy = null;
    }

    public AnnualChanges(final Integer newSantaBudget, final List<SantaGift> newGifts,
                         final List<Children> newChildren,
                         final List<ChildrenUpdate> childrenUpdates, final String strategy) {
        this.newSantaBudget = newSantaBudget;
        this.newGifts = newGifts;
        this.newChildren = newChildren;
        this.childrenUpdates = childrenUpdates;
        this.strategy = strategy;
    }

    public Integer getNewSantaBudget() {
        return newSantaBudget;
    }

    public List<SantaGift> getNewGifts() {
        return newGifts;
    }

    public List<Children> getNewChildren() {
        return newChildren;
    }

    public List<ChildrenUpdate> getChildrenUpdates() {
        return childrenUpdates;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setNewSantaBudget(final Integer newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    public void setNewGifts(final List<SantaGift> newGifts) {
        this.newGifts = newGifts;
    }

    public void setNewChildren(final List<Children> newChildren) {
        this.newChildren = newChildren;
    }

    public void setChildrenUpdates(final List<ChildrenUpdate> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }

    public void setStrategy(final String strategy) {
        this.strategy = strategy;
    }

    @Override
    public String toString() {
        return "AnnualChanges{"
                + "newSantaBudget=" + newSantaBudget
                + ", newGifts=" + newGifts
                + ", newChildren=" + newChildren
                + ", childrenUpdates=" + childrenUpdates
                + '}';
    }
}
