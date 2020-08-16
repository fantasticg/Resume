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
public class EducationContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<EducationItem> ITEMS = new ArrayList<EducationItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, EducationItem> ITEM_MAP = new HashMap<String, EducationItem>();

    public static void addItem(EducationItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    public static EducationItem createDummyItem(String id, String period, String schoolname, String major, String gpa, String remark ) {
        return new EducationItem(id, period, schoolname,  major, gpa, remark);
    }

    public static class EducationItem {

        public final String id;

        public final String period;

        public final String schoolname;

        public final String major;

        public final String gpa;

        public final String remark;


        public EducationItem(String id, String period, String schoolname, String major, String gpa, String remark) {
            this.id = id;
            this.period = period;
            this.schoolname = schoolname;
            this.major = major;
            this.gpa = gpa;
            this.remark = remark;
        }

        @Override
        public String toString() {
            return this.period + " " + this.schoolname + " " + this.major + " " + this.gpa+ " " + this.remark ;
        }
    }

}
