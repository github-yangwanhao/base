package cn.yangwanhao.util.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 杨万浩
 * @version V3.0
 * @since 2021/12/16 10:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusMachineRelation {
    /** 当前状态 */
    private String currentStatus;
    /** 下一状态 */
    private String nextStatus;
}
