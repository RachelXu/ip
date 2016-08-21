package dao;

import java.util.HashSet;
import java.util.Set;


/**
 * Area entity. @author MyEclipse Persistence Tools
 */

public class Area  implements java.io.Serializable {


    // Fields    

     private Integer areaId;
     private String areaName;
     private Set mediaDescs = new HashSet(0);


    // Constructors

    /** default constructor */
    public Area() {
    }

	/** minimal constructor */
    public Area(Integer areaId, String areaName) {
        this.areaId = areaId;
        this.areaName = areaName;
    }
    
    /** full constructor */
    public Area(Integer areaId, String areaName, Set mediaDescs) {
        this.areaId = areaId;
        this.areaName = areaName;
        this.mediaDescs = mediaDescs;
    }

   
    // Property accessors

    public Integer getAreaId() {
        return this.areaId;
    }
    
    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return this.areaName;
    }
    
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Set getMediaDescs() {
        return this.mediaDescs;
    }
    
    public void setMediaDescs(Set mediaDescs) {
        this.mediaDescs = mediaDescs;
    }
   








}