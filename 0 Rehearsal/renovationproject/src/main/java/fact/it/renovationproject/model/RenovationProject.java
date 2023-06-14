package fact.it.renovationproject.model;

public class RenovationProject {
    double length;
    double width;
    double height;
    int numberOfLayers;
    boolean ceilingIncluded;

    public RenovationProject(double length,double width,double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getLength() {
        return this.length;
    }

    public void setLength(double length) {
        this.length = length;
        return;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
        return;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
        return;
    }

    public int getNumberOfLayers() {
        return this.numberOfLayers;
    }

    public void setNumberOfLayers(int numberOfLayers) {
        this.numberOfLayers = numberOfLayers;
        return;
    }

    public boolean isCeilingIncluded() {
        return this.ceilingIncluded;
    }

    public void setCeilingIncluded(boolean ceilingIncluded) {
        this.ceilingIncluded = ceilingIncluded;
        return;
    }

    public double getAmountOfPaintInLitres() {
        //Exercise didn't include number of layers in formula
        double areaWalls = 2 * (this.length + this.width) * this.height * this.numberOfLayers;
        double areaCeiling = this.length * this.width;
        // One litre of paint per 10m2, so divide all areas by 10
        return (areaWalls + (this.isCeilingIncluded() ? areaCeiling : 0)) / 10;
    }


}
