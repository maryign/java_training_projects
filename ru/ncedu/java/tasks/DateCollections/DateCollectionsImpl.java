package ru.ncedu.java.tasks.DateCollections;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;

/**
 * Created by Mari on 09.04.2016.
 */
public class DateCollectionsImpl implements DateCollections {
    private int dateStyle = DateFormat.MEDIUM;
    private Map<String, Element> map;
//    private int elementsNumber;
//    private Calendar firstDate;
    /**
     * Sets a style of string representation of dates that is used by other methods of the class.<br/>
     * If this method is NOT called, the default {@link DateFormat#MEDIUM} style is used.
     *
     * @param dateStyle One of the style constants defined in the {@link DateFormat} class
     */
    @Override
    public void setDateStyle(int dateStyle) {
        this.dateStyle = dateStyle;

    }

    /**
     * Parses the <code>dateString</code> (a date with no time) to {@link Date} (with {@link DateFormat}))
     * and converts it to {@link Calendar}.
     *
     * @param dateString string compatible with a style set by {@link #setDateStyle(int)})
     * @throws ParseException if <code>dateString</code> can't be parsed
     */
    @Override
    public Calendar toCalendar(String dateString) throws ParseException {
//string->date
        DateFormat df = DateFormat.getDateInstance(this.dateStyle);
        Date date = df.parse(dateString);
        //date->calendar
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //converts it to {@link Calendar}.
        return cal;
    }

    /**
     * Returns string representation of {@link Calendar} (a date with no time)
     * with {@link DateFormat} using a style set by {@link #setDateStyle(int)}.<br/>
     * Note: the result depends on the system's Locale. E.g. if the locale is en_US
     * the example of the string is "Jan 15, 2015" (for style = {@link DateFormat#MEDIUM})
     *
     * @param date
     */
    @Override
    public String toString(Calendar date)  {
        //calendar->string

        //Locale current = Locale.getDefault();
        DateFormat df = DateFormat.getDateInstance(this.dateStyle, Locale.getDefault());
        String s = df.format(date);
        return s;
    }

    /**
     * Creates a map and adds <code>elementsNumber</code> instances of {@link Element} class
     * to the map (key,element), where key is the String representation of
     * <code>birthDate</code> field of the element (use {@link #toString(Calendar)}).<br/>
     * The parameters of an element's constructor must obey the following rules:
     * <dl>
     * <dt>birthDate</dt><dd>firstDate + i * 110 days (i is the index of the element)</dd>
     * <dt>lifetime (days)</dt><dd>random uniformly distributed {@code int} value
     * between 0 (inclusive) and 2000 (exclusive)</dd>
     * </dl>
     * The created map must be stored as a field.
     * Note: when implementing <code>getMainMap, getMainList, getSortedSubMap</code>
     * you can rely on the fact that this method is called BEFORE that methods.
     * Note 2: the work of this method depends on the style set by {@link #setDateStyle(int)}.
     *
     * @param elementsNumber the number of elements to instantiate
     * @param firstDate      birth date of the first element; the time fields (hours/minutes/..) do not matter
     */
    @Override
    public void initMainMap(int elementsNumber, Calendar firstDate) {

        Random rnd = new Random();
        int lifetime = rnd.nextInt(2000);
        Calendar birthDate ;
        Element el = new Element(firstDate, lifetime);

    this.map = new HashMap<String,Element>(elementsNumber);
        for(int i =0;i<map.size();i++){
//            birthDate = this.firstDate + i * 110;
        }
    }

    /**
     * Sets the given map to the the main field of the class.<br/>
     * Note: this method exists in order to test other methods
     * if {@link #initMainMap(int, Calendar)} has incorrect implementation.
     *
     * @param map
     */
    @Override
    public void setMainMap(Map<String, Element> map) {
        this.map = map;

    }

    /**
     * Returns the result of {@link #initMainMap(int, Calendar)} method.
     *
     * @return map, the main field of the class.
     * Can be null if <code>initMainMap</code> method was not called
     */
    @Override
    public Map<String, Element> getMainMap() {
        return null;
//        return this.initMainMap(this.elementsNumber,firstDate);
    }

    /**
     * Returns those entries of the main map, where elements' <code>birthDate</code> &gt; today
     * (i.e. elements to be born in future: not today and not in the past).
     * The resulting sub-map must be sorted according to the <code>birthDate</code>
     * (ascending order of dates; but it's not alphabetic natural order of keys!).
     *
     * @return sorted map containing a subset of the {@link #getMainMap()}
     */
    @Override
    public SortedMap<String, Element> getSortedSubMap() {
//        return map=new SortedMap<String, Element>() ;
        return null;
    }

    /**
     * Represents values of the main map as a {@link List}.
     * The list must be sorted according to the <code>birthDate</code> (ascending order).
     *
     * @return list with all the values of the {@link #getMainMap()}.
     */
    @Override
    public List<Element> getMainList() {
        List<Element> list = new ArrayList<Element>();
//        Iterator<Map<String, Element>> iter =
//        list.add
//                map.get()
//        Element.;
//        DateCollections.Element.
        return null;
    }

    /**
     * Sorts the given list according to the <code>deathDate</code> (ascending order).<br/>
     * Don't use {@link List#sort(Comparator)} method because it's since Java 8
     * (and Java version in Skill Bench is 7 now). Use a method of {@link Collections}.
     *
     * @param list
     */
    @Override
    public void sortList(List<Element> list) {

    }

    /**
     * Removes some elements from the given list. The <code>birthDate</code> of removing elements
     * must be in winter (i.e. in December, January or February).<br/>
     * Hint: remove elements via {@link Iterator}.
     *
     * @param list
     */
    @Override
    public void removeFromList(List<Element> list) {

    }
}
