package cn.yangwanhao.util.support;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import cn.yangwanhao.util.po.StatusMachineRelation;
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

    protected Map<Class, List<StatusMachineRelation>> map = new HashMap<>();

    protected abstract void init();

    public boolean checkStatus(Class clazz, String currentStatus, String nextStatus) {
        List<StatusMachineRelation> statusMachineRelations = map.get(clazz);
        if (statusMachineRelations == null || statusMachineRelations.size() == 0) {
            throw new RuntimeException(clazz.getName() + "没有被初始化");
        }
        List<String> allowedStatusList = statusMachineRelations.stream()
            .filter(r -> r.getCurrentStatus().equals(currentStatus))
            .map(StatusMachineRelation::getNextStatus)
            .collect(Collectors.toList());
        log.info("状态枚举[{}],当前状态:[{}],期望流转状态:[{}],允许流转状态:{}", clazz.getName(), currentStatus, nextStatus, allowedStatusList);
        for (StatusMachineRelation relation : statusMachineRelations) {
            if (relation.getCurrentStatus().equals(currentStatus) &&
                relation.getNextStatus().equals(nextStatus)) {
                return true;
            }
        }
        return false;
    }
}
