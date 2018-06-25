/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WeatherObserved generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`WeatherObserved`")
public class WeatherObserved implements Serializable {

    private Integer id;
    private Date weatherDate;
    private Short tempMax;
    private Short tempMin;
    private Short windSpeed;
    private Short windDir;
    private Float precip;
    private Short thunderStorms;
    private Timestamp timeStamp;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`WeatherDate`", nullable = true)
    public Date getWeatherDate() {
        return this.weatherDate;
    }

    public void setWeatherDate(Date weatherDate) {
        this.weatherDate = weatherDate;
    }

    @Column(name = "`TempMax`", nullable = true, scale = 0, precision = 5)
    public Short getTempMax() {
        return this.tempMax;
    }

    public void setTempMax(Short tempMax) {
        this.tempMax = tempMax;
    }

    @Column(name = "`TempMin`", nullable = true, scale = 0, precision = 3)
    public Short getTempMin() {
        return this.tempMin;
    }

    public void setTempMin(Short tempMin) {
        this.tempMin = tempMin;
    }

    @Column(name = "`WindSpeed`", nullable = true, scale = 0, precision = 3)
    public Short getWindSpeed() {
        return this.windSpeed;
    }

    public void setWindSpeed(Short windSpeed) {
        this.windSpeed = windSpeed;
    }

    @Column(name = "`WindDir`", nullable = true, scale = 0, precision = 5)
    public Short getWindDir() {
        return this.windDir;
    }

    public void setWindDir(Short windDir) {
        this.windDir = windDir;
    }

    @Column(name = "`Precip`", nullable = true, scale = 2, precision = 4)
    public Float getPrecip() {
        return this.precip;
    }

    public void setPrecip(Float precip) {
        this.precip = precip;
    }

    @Column(name = "`ThunderStorms`", nullable = true, scale = 0, precision = 3)
    public Short getThunderStorms() {
        return this.thunderStorms;
    }

    public void setThunderStorms(Short thunderStorms) {
        this.thunderStorms = thunderStorms;
    }

    @Column(name = "`TimeStamp`", nullable = true)
    public Timestamp getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WeatherObserved)) return false;
        final WeatherObserved weatherObserved = (WeatherObserved) o;
        return Objects.equals(getId(), weatherObserved.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

