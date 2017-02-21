package genericsrefresher;

/**
 * Created by sheamusohalloran on 20/02/2017.
 */
public class Golfer implements Comparable<Golfer> {
    public String first;
    public String last;
    public int score;

    public Golfer(String first, String last, int score) {
        this.first = first;
        this.last = last;
        this.score = score;
    }

    public Golfer(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public Golfer() {
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Golfer golfer) {
        return score - golfer.score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Golfer golfer = (Golfer) o;

        if (score != golfer.score) return false;
        if (!first.equals(golfer.first)) return false;
        return last.equals(golfer.last);
    }

    @Override
    public int hashCode() {
        int result = first.hashCode();
        result = 31 * result + last.hashCode();
        result = 31 * result + score;
        return result;
    }

    @Override
    public String toString() {
        return "Golfer{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", score=" + score +
                '}';
    }
}
