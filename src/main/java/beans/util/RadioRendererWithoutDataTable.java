package beans.util;

import com.sun.faces.renderkit.RenderKitUtils;
import com.sun.faces.util.Util;

import javax.faces.component.UIComponent;
import javax.faces.component.ValueHolder;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class RadioRendererWithoutDataTable extends com.sun.faces.renderkit.html_basic.RadioRenderer {
    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {

        rendererParamsNotNull(context, component);

        if (!shouldEncode(component)) {
            return;
        }

        ResponseWriter writer = context.getResponseWriter();
        assert (writer != null);

        String alignStr;
        Object borderObj;
        boolean alignVertical = false;
        int border = 0;

        if (null != (alignStr = (String) component.getAttributes().get("layout"))) {
            alignVertical = alignStr.equalsIgnoreCase("pageDirection");
        }
        if (null != (borderObj = component.getAttributes().get("border"))) {
            border = (Integer) borderObj;
        }

        Converter converter = null;
        if (component instanceof ValueHolder) {
            converter = ((ValueHolder) component).getConverter();
        }

//      renderBeginText(component, border, alignVertical, context, true);

        Iterator<SelectItem> items = RenderKitUtils.getSelectItems(context, component);

        Object currentSelections = getCurrentSelectedValues(component);
        Object[] submittedValues = getSubmittedSelectedValues(component);
        Map<String, Object> attributes = component.getAttributes();

        int idx = -1;
        while (items.hasNext()) {
            SelectItem curItem = items.next();
            idx++;
            // If we come across a group of options, render them as a nested
            // table.
            if (curItem instanceof SelectItemGroup) {
                // write out the label for the group.
                if (curItem.getLabel() != null) {
//                  if (alignVertical) {
//                      writer.startElement("tr", component);
//                  }
                    //writer.startElement("td", component);
                    writer.writeText(curItem.getLabel(), component, "label");
//                  writer.endElement("td");
//                  if (alignVertical) {
//                      writer.endElement("tr");
//                  }

                }
//              if (alignVertical) {
//                  writer.startElement("tr", component);
//              }
//              writer.startElement("td", component);
//              writer.writeText("\n", component, null);
//              renderBeginText(component, 0, alignVertical, context, false);
                OptionComponentInfo optionInfo = new OptionComponentInfo((String) attributes.get("disabledClass"),
                        (String) attributes.get("enabledClass"), (String) attributes.get("unselectedClass"),
                        (String) attributes.get("selectedClass"), Util.componentIsDisabled(component), isHideNoSelection(component));
                // render options of this group.
                SelectItem[] itemsArray = ((SelectItemGroup) curItem).getSelectItems();
                for (int i = 0; i < itemsArray.length; ++i) {
                    renderOption(context, component, converter, itemsArray[i], currentSelections, submittedValues, alignVertical, i,
                            optionInfo);
                }
//              renderEndText(component, alignVertical, context);
//              writer.endElement("td");
//              if (alignVertical) {
//                  writer.endElement("tr");
//                  writer.writeText("\n", component, null);
//              }
            } else {

                OptionComponentInfo optionInfo = new OptionComponentInfo((String) attributes.get("disabledClass"),
                        (String) attributes.get("enabledClass"), (String) attributes.get("unselectedClass"),
                        (String) attributes.get("selectedClass"), Util.componentIsDisabled(component), isHideNoSelection(component));
                renderOption(context, component, converter, curItem, currentSelections, submittedValues, alignVertical, idx, optionInfo);
            }
        }

        //renderEndText(component, alignVertical, context);
    }
}