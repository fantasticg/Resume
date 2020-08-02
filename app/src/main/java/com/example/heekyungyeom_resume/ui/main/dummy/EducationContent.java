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

    private static final int COUNT = 3;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(EducationItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static EducationItem createDummyItem(int position) {
        return new EducationItem(String.valueOf(position), "2005/03-2006/08", "동국대학교 전산원",  "멀티미디어과", "4.3/4.5", "조기졸업");
    }


    /**
     * A dummy item representing a piece of content.
     */
    public static class EducationItem {
        public final String id;
        public final String yearmonth;
        public final String schoolname;
        public final String major;
        public final String gpa;
        public final String remark;

        public EducationItem(String id, String yearmonth, String schoolname, String major, String gpa, String remark) {
            this.id = id;
            this.yearmonth = yearmonth;
            this.schoolname = schoolname;
            this.major = major;
            this.gpa = gpa;
            this.remark = remark;
        }

        @Override
        public String toString() {
            return " year/month:" +  yearmonth + " school_name:" + schoolname + " major:" +  major + " GPA:" +  gpa + " Remark:" + remark;
        }
    }
}
