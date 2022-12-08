/**
 * @author 11214
 * @since 2022/12/8 10:34
 * <p>
 * 小扣打算给自己的 VS code 安装使用插件，初始状态下带宽每分钟可以完成 1 个插件的下载。假定每分钟选择以下两种策略之一:
 * 使用当前带宽下载插件
 * 将带宽加倍（下载插件数量随之加倍）
 * 请返回小扣完成下载 n 个插件最少需要多少分钟。
 * 注意：实际的下载的插件数量可以超过 n 个
 */
public class SolutionLCS1 {
    public int leastMinutes(int n) {
        int step = 0;
        int start = 1;
        while (start < n) {
            start *= 2;
            step += 1;
        }
        return step + 1;
    }
}
