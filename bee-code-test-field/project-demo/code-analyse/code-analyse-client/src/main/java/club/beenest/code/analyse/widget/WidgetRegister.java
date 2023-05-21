/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.code.analyse.widget;

import java.util.HashMap;
import java.util.Map;

public class WidgetRegister {
    private static final Map<String, Object> widgets = new HashMap<>();

    public static void register(String id, Object widget) {
        widgets.put(id, widget);
    }

    public static <T> T getWidget(String id, Class<T> clazz) {
        return clazz.cast(widgets.get(id));
    }
}
