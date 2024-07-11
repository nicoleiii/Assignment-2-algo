abstract class PCComponent {
    private final String name;
    private final double price;

    public PCComponent(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public abstract String getType();
}

class CPU extends PCComponent {
    public CPU(String name, double price) {
        super(name, price);
    }

    @Override
    public String getType() {
        return "CPU";
    }
}

class GPU extends PCComponent {
    public GPU(String name, double price) {
        super(name, price);
    }

    @Override
    public String getType() {
        return "GPU";
    }
}

class RAM extends PCComponent {
    public RAM(String name, double price) {
        super(name, price);
    }

    @Override
    public String getType() {
        return "RAM";
    }
}

class Storage extends PCComponent {
    public Storage(String name, double price) {
        super(name, price);
    }

    @Override
    public String getType() {
        return "Storage";
    }
}


class PCSetup {
    private PCComponent[] components;

    public PCSetup(PCComponent[] components) {
        this.components = components;
    }

    public PCComponent[] getComponents() {
        return components;
    }

    public void setComponents(PCComponent[] components) {
        this.components = components;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (PCComponent component : components) {
            totalPrice += component.getPrice();
        }
        return totalPrice;
    }

    public double getTotalPriceByType(String type) {
        double totalPrice = 0;
        for (PCComponent component : components) {
            if (component.getType().equals(type)) {
                totalPrice += component.getPrice();
            }
        }
        return totalPrice;
    }

    public double getTotalCPUCost() {
        return getTotalPriceByType("CPU");
    }

    public double getTotalGPUCost() {
        return getTotalPriceByType("GPU");
    }

    public double getTotalRAMCost() {
        return getTotalPriceByType("RAM");
    }

    public double getTotalStorageCost() {
        return getTotalPriceByType("Storage");
    }
}
public class Main {
    public static void main(String[] args) {
        PCComponent[] gamingComponents = {
            new CPU("Intel Core i9-12900K", 499.99),
            new GPU("NVIDIA GeForce RTX 3080", 699.99),
            new RAM("Corsair Vengeance LPX 32GB", 199.99),
            new Storage("Samsung 1TB SSD", 149.99)
        };

        PCSetup gamingPC = new PCSetup(gamingComponents);

        System.out.println("Setup 1: Gaming PC");
        displaySetupCost(gamingPC);

        System.out.println();

        PCComponent[] workstationComponents = {
            new CPU("AMD Ryzen 9 5900X", 549.99),
            new GPU("NVIDIA Quadro RTX 5000", 1199.99),
            new RAM("Corsair Vengeance LPX 64GB", 299.99),
            new Storage("Western Digital 2TB NVMe SSD", 249.99)
        };

        PCSetup workstationPC = new PCSetup(workstationComponents);

        System.out.println("Setup 2: Workstation PC");
        displaySetupCost(workstationPC);
    }

    private static void displaySetupCost(PCSetup pcSetup) {
        System.out.println("Total Cost of PC Setup: $" + pcSetup.getTotalPrice());
        System.out.println("CPU Cost: $" + pcSetup.getTotalCPUCost());
        System.out.println("GPU Cost: $" + pcSetup.getTotalGPUCost());
        System.out.println("RAM Cost: $" + pcSetup.getTotalRAMCost());
        System.out.println("Storage Cost: $" + pcSetup.getTotalStorageCost());
    }
}
