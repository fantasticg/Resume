package com.example.heekyungyeom_resume.ui.main.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class ExperienceContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<ExperienceItem> ITEMS = new ArrayList<ExperienceItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, ExperienceItem> ITEM_MAP = new HashMap<String, ExperienceItem>();

    public static void addItem(ExperienceItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    public static ExperienceItem createDummyItem(String id, String period, String company, String project, String remark ) {
        return new ExperienceItem(id, period, company, project, remark);
    }

    public static class ExperienceItem {

        public final String id;

        public final String period;

        public final String company;

        public final String project;

        public final String remark;


        public ExperienceItem(String id, String period, String company, String project, String remark) {
            this.id = id;
            this.period = period;
            this.company = company;
            this.project = project;
            this.remark = remark;
        }

        @Override
        public String toString() {
            return this.period + " " + this.company + " " + this.project + " " + this.remark ;
        }
    }

}
