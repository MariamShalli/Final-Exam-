package finalexam.task4;

import java.io.Serializable;

public class Campaign implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private double budget;

    public Campaign(String name, double budget) {
        this.name = name;
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public double getBudget() {
        return budget;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Campaign campaign = (Campaign) obj;

        return name != null ? name.equals(campaign.name) : campaign.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
