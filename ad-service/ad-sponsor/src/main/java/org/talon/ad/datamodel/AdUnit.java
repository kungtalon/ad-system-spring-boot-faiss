package org.talon.ad.datamodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.talon.ad.constant.CommonStatus;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Zelong
 * On 2022/5/2
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ad_unit")
public class AdUnit extends AdEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "plan_id", nullable = false)
    private Long planId;

    @Column(name = "unit_name", nullable = false)
    private String unitName;

    @Column(name = "unit_status", nullable = false)
    private Integer unitStatus;

    //position type: banner, card, popup window ..
    @Column(name = "position_type", nullable = false)
    private Integer positionType;

    @Column(name = "budget", nullable = false)
    private Long budget;

    @Column(name = "create_time", nullable = false)
    private Date createTime;

    @Column(name = "update_time", nullable = false)
    private Date updateTime;

    public AdUnit(Long planId, String unitName, Integer positionType, Long budget) {
        this.planId = planId;
        this.unitName = unitName;
        this.unitStatus = CommonStatus.VALID.getStatus();
        this.positionType = positionType;
        this.budget = budget;
        this.createTime = new Date();
        this.updateTime = this.createTime;
    }
}
