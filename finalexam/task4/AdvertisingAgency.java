package finalexam.task4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AdvertisingAgency implements LegalEntity {
    private String address;
    private String vatNumber;
    private List<Campaign> campaigns;

    public AdvertisingAgency(String address, String vatNumber) {
        this.address = address;
        this.vatNumber = vatNumber;
        this.campaigns = new ArrayList<>();
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getVatNumber() {
        return vatNumber;
    }

    public void addCampaign(Campaign campaign) {
        if (!campaigns.contains(campaign)) {
            campaigns.add(campaign);
        }
    }

    public boolean deleteCampaign(Campaign campaign) {
        return campaigns.remove(campaign);
    }

    public void saveCampaignsToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(campaigns);
        }
    }

    public void loadCampaignsFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            campaigns = (List<Campaign>) ois.readObject();
        }
    }

    public List<Campaign> getCampaigns() {
        return campaigns;
    }
}
