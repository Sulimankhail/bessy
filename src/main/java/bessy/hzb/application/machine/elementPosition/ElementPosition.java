package bessy.hzb.application.machine.elementPosition;

import bessy.hzb.application.machine.beamPosition.BeamPositions;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class ElementPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Double l;
    private int n;
    private String name;
    private String type;
    private double x;
    private Double px;
    private Double y;
    private Double py;
    private Double dt;
    private Double ct;
    public ElementPosition(String name, Double l, String type, int n, double x, double px, double y, double py, double dt, double ct) {
        this.name = name;
        this.l = l;
        this.type = type;
        this.x = x;
        this.px = px;
        this.y = y;
        this.py = py;
        this.dt = dt;
        this.ct = ct;
    }

    public Double getL() {
        return l;
    }
    public void setL(Double l) {
        this.l = l;
    }
    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public ElementPosition(Double l, int n) {
        this.l = l;
        this.n = n;
    }
    public ElementPosition() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public Double getPx() {
        return px;
    }

    public void setPx(Double px) {
        this.px = px;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getPy() {
        return py;
    }

    public void setPy(Double py) {
        this.py = py;
    }

    public Double getDt() {
        return dt;
    }

    public void setDt(Double dt) {
        this.dt = dt;
    }

    public Double getCt() {
        return ct;
    }

    public void setCt(Double ct) {
        this.ct = ct;
    }
}
