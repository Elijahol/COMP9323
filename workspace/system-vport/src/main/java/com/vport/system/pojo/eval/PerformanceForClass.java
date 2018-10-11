package com.vport.system.pojo.eval;

public class PerformanceForClass implements Comparable<PerformanceForClass>{
    private String name;
    private String chName;
    private Double score;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getChName() {
        return chName;
    }
    public void setChName(String chName) {
        this.chName = chName;
    }
    public Double getScore() {
        return score;
    }
    public void setScore(Double score) {
        this.score = score;
    }
    @Override
    public int compareTo(PerformanceForClass o) {
        
        return this.getScore().compareTo(o.getScore());
    }
    @Override
    public String toString() {
        return "PerformanceForClass [name=" + name + ", chName=" + chName + ", score=" + score + "]";
    }
    
    
}
