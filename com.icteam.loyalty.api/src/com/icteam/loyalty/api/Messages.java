package com.icteam.loyalty.api;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.MissingResourceException;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.widgets.Display;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.annotations.Component;
import org.osgi.util.tracker.ServiceTracker;

@Component(service = DynamicMessagesService.class)
public class Messages extends ServiceTracker<DynamicMessagesService, DynamicMessagesService> implements DynamicMessagesService {
//    private static final String NO_FILTER = "(messagesFor=*)";

    private static final String MISSING_RESOURCE = "???";

    private static final String BUNDLE_NAME = "com.icteam.loyalty.api.messages"; //$NON-NLS-1$

    private static BundleContext bundleContext;

    private static Map<String, String> messages = new HashMap<>();

    private static Map<String, Map<String, String>> classesMessages = new HashMap<>();

    public String advancedSearchDialog_ClearFilter;

    public String list_not_empty;

    public String nToMSrcLabel;
    public String nToMDestLabel;

    public String ellipsis;
    public String filters;

    public String selectAll;
    public String deselectAll;

    public String filterTableDialog_Title;
    public String filterTableDialog_Group;

    public String advancedSearchDialog_Title;

    public String listColumnTableDialog_Title;
    public String listColumnTableDialog_Group;

    public String validation_error;
    public String value_not_null;
    public String value_required;
    public String value_not_min_length;
    public String value_format_invalid;
    public String value_format_invalid_message;
    public String email_not_invalid;

    public String readonly_marker;

    public String save;
    public String cancel;

    public String refresh;

    public String Boolean_false; // Boolean oggetto con la maiuscola
    public String Boolean_true;

    public String dnd_warning_title;
    public String dnd_warning_message;

    public String version_status_line;
    public String version_status_line_tooltip;

    public String database_status_line;
    public String database_status_line_tooltip;

    public String filter_message;
    public String filter_message_warning;

    public String load_error;

    public String exit_not_allowed;

    private final static List<ServiceReference<DynamicMessagesService>> referencesToAdd = new ArrayList<>();
    private final static List<ServiceReference<DynamicMessagesService>> referencesToRemove = new ArrayList<>();

    private static CustomMessagesService customMessagesService;

    public Messages() {
        super(bundleContext = FrameworkUtil.getBundle(Messages.class).getBundleContext(), DynamicMessagesService.class, null);
    }

    public CustomMessagesService getCustomMessagesService() {
        return customMessagesService;
    }

    public void setCustomMessagesService(CustomMessagesService customMessagesService) {
        Messages.customMessagesService = customMessagesService;
    }

    public static Messages get() {
        try {
            return RWT.NLS.getISO8859_1Encoded(BUNDLE_NAME, Messages.class);
        } catch (MissingResourceException mre) {
            mre.printStackTrace();
            System.exit(1);
            return null;
        } catch (IllegalStateException ise) {
            Messages m = new Messages();

            for (Field field : m.getClass().getFields()) {
                if (String.class.isAssignableFrom(field.getType())) {
                    try {
                        field.set(m, field.getName());
                    } catch (IllegalArgumentException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }

            return m;
        }
    }

    public static String getFormatted(String translateKey, Object... arguments) {
        return MessageFormat.format(translateKey, arguments);
    }

    public static String get(Class< ? > clazz) {
        return get(clazz, "");
    }

    public static String get(Class< ? > clazz, String property) {
        checkDeferredServices();

        String keyClass = clazz.getSimpleName();
        String key = key(keyClass, property);

        String message = customMessagesService.getCustomMessage(key);

        if (message == null) {
            Map<String, String> classMessages = classesMessages.get(keyClass);

            if (classMessages != null) {
                message = classMessages.get(property);
            }

            if (message == null) {
                message = missingKey(key);
            }
        }

        return message;
    }

//    private static String getInternal(String key, String filter) {
//        try {
//            String customMessage = customMessagesService.getCustomMessage(key);
//
//            if (customMessage != null) {
//                return customMessage;
//            }
//
//            BundleContext bundleContext = FrameworkUtil.getBundle(Messages.class).getBundleContext();
//
//            Collection<ServiceReference<DynamicMessagesService>> serviceReferences = bundleContext.getServiceReferences(DynamicMessagesService.class,
//                    filter);
//            if (serviceReferences.isEmpty() && !NO_FILTER.equals(filter)) {
//                return getInternal(key, NO_FILTER);
//            }
//
//            for (ServiceReference<DynamicMessagesService> serviceReference : serviceReferences) {
//                DynamicMessagesService dynamicMessagesService = bundleContext.getService(serviceReference);
//                if (dynamicMessagesService != null) {
//                    try {
//                        Class< ? extends DynamicMessagesService> class1 = dynamicMessagesService.getClass();
//                        Method getMethod = class1.getMethod("get", (Class[]) null);
//
//                        return (String) class1.getField(key).get(getMethod.invoke(null, (Object[]) null));
//                    } catch (NoSuchMethodException | SecurityException | IllegalArgumentException | IllegalAccessException
//                            | InvocationTargetException e) {
//                        e.printStackTrace();
//                    } catch (NoSuchFieldException e) {
//                        continue; // to next service
//                    }
//                }
//            }
//        } catch (InvalidSyntaxException e1) {
//            e1.printStackTrace();
//        }
//
//        return missingKey(key);
//    }

    public static String get(String key) {
        checkDeferredServices();

        String message = customMessagesService.getCustomMessage(key);

        if (message == null) {
            message = messages.get(key);

            if (message == null) {
                message = missingKey(key);
            }
        }

        return message;
    }

    @Override
    public DynamicMessagesService addingService(ServiceReference<DynamicMessagesService> reference) {
        DynamicMessagesService service = bundleContext.getService(reference);

        if (Display.getDefault() == null) {
            addServiceReference(reference);
        } else {
            addServiceMessages(service);
        }

        return service;
    }

    private static void addServiceReference(ServiceReference<DynamicMessagesService> reference) {
        referencesToAdd.add(reference);

        referencesToRemove.remove(reference);
    }

    private static void removeServiceReference(ServiceReference<DynamicMessagesService> reference) {
        referencesToAdd.remove(reference);

        referencesToRemove.add(reference);
    }

    private static void addServiceMessages(DynamicMessagesService service) {
        for (Entry<String, String> message : getMessages(service).entrySet()) {
            messages.put(message.getKey(), message.getValue());
        }

        for (Entry<String, Map<String, String>> cms : getClassesMessages(service).entrySet()) {
            String keyClass = cms.getKey();

            Map<String, String> classMessages = classesMessages.get(keyClass);
            if (classMessages == null) {
                classesMessages.put(keyClass, classMessages = new HashMap<>());
            }

            for (Entry<String, String> cm : cms.getValue().entrySet()) {
                classMessages.put(cm.getKey(), cm.getValue());
            }
        }
    }

    @Override
    public void removedService(ServiceReference<DynamicMessagesService> reference, DynamicMessagesService service) {
        if (Display.getDefault() == null) {
            removeServiceReference(reference);
        } else {
            removeServiceMessages(service);
        }
    }

    private static void removeServiceMessages(DynamicMessagesService service) {
        if (service == null) {
            return;
        }

        for (String key : getMessages(service).keySet()) {
            messages.remove(key);
        }

        for (Entry<String, Map<String, String>> cms : getClassesMessages(service).entrySet()) {
            String keyClass = cms.getKey();

            Map<String, String> classMessages = classesMessages.get(keyClass);
            if (classMessages != null) {
                for (String keyObject : cms.getValue().keySet()) {
                    classMessages.remove(keyObject);
                }
            }

            if (classMessages != null && classMessages.isEmpty()) {
                classesMessages.remove(keyClass);
            }
        }
    }

    private static Map<String, String> getMessages(DynamicMessagesService messagesService) {
        Field[] fields = messagesService.getClass().getFields();

        Map<String, String> messages = new HashMap<>();

        for (Field field : fields) {
            String key = field.getName();
            String value = getValue(messagesService, field);

            messages.put(key, value);
        }

        return messages;
    }

    private static Map<String, Map<String, String>> getClassesMessages(DynamicMessagesService messagesService) {
        Field[] fields = messagesService.getClass().getFields();

        Map<String, Map<String, String>> classesMessages = new HashMap<>();

        for (Field field : fields) {
            String key = field.getName();
            String value = getValue(messagesService, field);

            String keyClass = key;
            String keyObject = "";

            int classSep = key.indexOf('_');

            if (classSep != -1) {
                keyClass = key.substring(0, classSep);
                keyObject = key.substring(classSep + 1);
            }

            Map<String, String> classMessages = classesMessages.get(keyClass);
            if (classMessages == null) {
                classesMessages.put(keyClass, classMessages = new HashMap<>());
            }

            classMessages.put(keyObject, value);
        }

        return classesMessages;
    }

    private static String getValue(DynamicMessagesService messagesService, Field field) {
        Class< ? extends DynamicMessagesService> clazz = messagesService.getClass();
        try {
            Method getMethod = clazz.getMethod("get", (Class[]) null);

            return (String) field.get(getMethod.invoke(null, (Object[]) null));
        } catch (NoSuchMethodException | SecurityException | IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static boolean contains(String key) {
        checkDeferredServices();

        return containsCustomMessage(key) || messages.containsKey(key);
    }

    private static void checkDeferredServices() {
        for (Iterator<ServiceReference<DynamicMessagesService>> iterator = referencesToAdd.iterator(); iterator.hasNext();) {
            ServiceReference<DynamicMessagesService> reference = iterator.next();

            addServiceMessages(FrameworkUtil.getBundle(Messages.class).getBundleContext().getService(reference));

            iterator.remove();
        }

        for (Iterator<ServiceReference<DynamicMessagesService>> iterator = referencesToRemove.iterator(); iterator.hasNext();) {
            ServiceReference<DynamicMessagesService> reference = iterator.next();

            removeServiceMessages(FrameworkUtil.getBundle(Messages.class).getBundleContext().getService(reference));

            iterator.remove();
        }
    }

    private static boolean containsCustomMessage(String key) {
        return customMessagesService.containsCustomMessage(key);
    }

    private static boolean containsCustomClassMessage(String keyClass, String keyObject) {
        return customMessagesService.containsCustomClassMessage(keyClass, keyObject);
    }

    public static boolean contains(String keyClass, String keyObject) {
        checkDeferredServices();

        return containsCustomClassMessage(keyClass, keyObject)
                || classesMessages.containsKey(keyClass)
                && classesMessages.get(keyClass).containsKey(keyObject);
    }

    public static List<String> getKeys(String keyClass, String match) {
        checkDeferredServices();

        List<String> keys = new ArrayList<>();
        String lowerMatch = match.toLowerCase();
        Map<String, String> classMessages = classesMessages.get(keyClass);

        if (classMessages != null) {
            for (Entry<String, String> message : classMessages.entrySet()) {
                if (message.getValue().toLowerCase().indexOf(lowerMatch) != -1) {
                    keys.add(message.getKey());
                }
            }
        }

        Map<String, String> customClassMessages = customMessagesService.getKeys(keyClass);
        if (customClassMessages != null) {
            for (Entry<String, String> message : customClassMessages.entrySet()) {
                if (message.getValue().toLowerCase().indexOf(lowerMatch) != -1) {
                    String key = message.getKey();

                    if (keys.contains(key)) {
                        keys.remove(key);
                    }

                    keys.add(key);
                }
            }
        }

        return keys;
    }

    private static String key(String keyClass, String keyObject) {
        return keyClass + "_" + keyObject;
    }

    private static String missingKey(String key) {
        return MISSING_RESOURCE + key + MISSING_RESOURCE;
    }
}
