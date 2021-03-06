package cn.yangwanhao.util.support;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import cn.yangwanhao.util.po.StatusMachineRelation;
import cn.yangwanhao.util.util.CollectionUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * 状态机抽象工具类
 *
 * @author 杨万浩
 * @version V3.0
 * @since 2021/12/16 10:40
 */
@Slf4j
public abstract class AbstractStatusMachine {

    protected Map<Class<?>, List<StatusMachineRelation>> map = new HashMap<>();

    protected abstract Class<?> enumClass();

    protected abstract void init();

    /**
     * 校验状态枚举是否被允许从当前状态流转至期望状态
     * @param currentStatus 当前状态
     * @param nextStatus 期望流转至状态
     * @return 校验结果
     */
    public boolean checkStatus(String currentStatus, String nextStatus) {
        boolean flag = false;
        List<StatusMachineRelation> statusMachineRelations = map.get(enumClass());
        if (statusMachineRelations == null || statusMachineRelations.size() == 0) {
            throw new RuntimeException(enumClass().getName() + "没有被初始化");
        }
        // 根据当前状态筛选出可以被允许流转的状态
        List<String> allowedStatusList = statusMachineRelations.stream()
            .filter(r -> r.getCurrentStatus().equals(currentStatus))
            .map(StatusMachineRelation::getNextStatus)
            .collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(allowedStatusList) && allowedStatusList.contains(nextStatus)) {
            flag = true;
        }
        log.info("状态校验结果:[{}},枚举[{}],当前状态:[{}],期望流转状态:[{}],允许流转状态:{}", flag ? "成功":"失败", enumClass().getName(), currentStatus, nextStatus, allowedStatusList);
        return flag;
    }
}
