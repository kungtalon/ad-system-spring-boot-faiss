package org.talon.ad.datamodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.talon.ad.constant.CommonStatus;
import org.talon.ad.dump.table.AdPlanTable;

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
@Table(name = "ad_plan")
public class AdPlan extends AdEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "plan_name", nullable = false)
    private String planName;

    @Column(name = "plan_status", nullable = false)
    private Integer planStatus;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @Column(name = "create_time", nullable = false)
    private Date createTime;

    @Column(name = "update_time", nullable = false)
    private Date updateTime;

    public AdPlan(Long userId, String planName, Date startDate, Date endDate) {
        this.userId = userId;
        this.planName = planName;
        this.planStatus = CommonStatus.VALID.getStatus();
        this.startDate = startDate;
        this.endDate = endDate;
        this.createTime = new Date();
        this.updateTime = this.createTime;
    }
}
