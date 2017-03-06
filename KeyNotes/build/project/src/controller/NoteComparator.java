package controller;

import java.util.Comparator;

import model.Note;

public class NoteComparator {
    public static Comparator<Note> compareToTitle() {
        return new Comparator<Note>() {

			@Override
			public int compare(Note n1, Note n2) {
				return n1.compareToTitle(n2);
			}
            // compare using title
        };
    }

    public static Comparator<Note> compareToDate() {
        return new Comparator<Note>() {

			@Override
			public int compare(Note n1, Note n2) {
				return n1.compareToDate(n2);
			}
            // compare using date
        };
    }
    
    public static Comparator<Note> compareToKeywords() {
        return new Comparator<Note>() {

        	@Override
			public int compare(Note n1, Note n2) {
				return n1.compareToKeywords(n2);
			}
            // compare using keywords
        };
    }
}
