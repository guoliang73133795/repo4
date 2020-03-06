package cn.itcast.web.damain;

public class Salgrade {
    private Double grade;
    private Double losal;
    private Double hisal;

    public Salgrade() {
    }

    public Salgrade(Double grade, Double losal, Double hisal) {
        this.grade = grade;
        this.losal = losal;
        this.hisal = hisal;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Double getLosal() {
        return losal;
    }

    public void setLosal(Double losal) {
        this.losal = losal;
    }

    public Double getHisal() {
        return hisal;
    }

    public void setHisal(Double hisal) {
        this.hisal = hisal;
    }

    @Override
    public String toString() {
        return "Salgrade{" + "grade=" + grade + ", losal=" + losal + ", hisal=" + hisal + '}';
    }
}
