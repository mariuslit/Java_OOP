package k_2_18_Map_OrientacinioSportoVarzybos_100proc;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.TreeSet;

public class Sportininkas implements Comparable<Sportininkas> {

    private String name;
    private String lastName;
    private Integer number;
    private LocalTime startTime;
    private LocalTime finalTime;
    private Set<Integer> punktai = new TreeSet<>(); // aplankytu punktu sąrašas

    public Sportininkas(String name, String lastName, Integer number, LocalTime startDate, LocalTime finishDate) {
        this.name = name;
        this.lastName = lastName;
        this.number = number;
        this.startTime = startDate;
        this.finalTime = finishDate;
    }

    public String getDuration() {

        Long duration = Duration.between(startTime, finalTime).getSeconds();

        long second = duration % 60;
        long minute = (duration / 60) % 60;
        long hour = (duration / (60 * 60)) % 24;

        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    @Override
    public int compareTo(Sportininkas o) {

//        Sportininkas o = (Sportininkas) obj;

//        if (this.getDuration() != null && this.getDuration() > o.getDuration()) return 1;
//        if (this.getDuration() != null && this.getDuration() < o.getDuration()) return -1;

        if (this.getPunktai() != null && this.getPunktai().size() > o.getPunktai().size()) return 1;
        if (this.getPunktai() != null && this.getPunktai().size() < o.getPunktai().size()) return -1;

//        if (this.getDuration() != null && !this.getDuration().equals(o.getDuration()))  return -1;
        // arba
        return this.getDuration().compareTo(o.getDuration());
//        return 0;
    }

    @Override
    public String toString() {

        return String.format("%-12.12s ", getName() + " " + getLastName());
    }

    public String timeTotoString(LocalTime time) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm:ss");

        return formatter.format(time);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getFinalTime() {
        return finalTime;
    }

    public void setFinalTime(LocalTime finalTime) {
        this.finalTime = finalTime;
    }

    public Set<Integer> getPunktai() {
        return punktai;
    }

    public void addPunktai(Integer punktas) {
        this.punktai.add(punktas);
    }
}
