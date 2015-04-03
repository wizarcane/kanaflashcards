package erik.lim.kanaflashcards.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by erikgabriellim on 4/3/15.
 */
public class Kana implements Parcelable {
    public static final String COLUMN_SYLLABLE = "syllable";
    public static final String COLUMN_ROMAJI = "romaji";

    public String syllable;
    public String romaji;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.syllable);
        dest.writeString(this.romaji);
    }

    public Kana() {
    }

    private Kana(Parcel in) {
        this.syllable = in.readString();
        this.romaji = in.readString();
    }

    public static final Creator<Kana> CREATOR = new Creator<Kana>() {
        public Kana createFromParcel(Parcel source) {
            return new Kana(source);
        }

        public Kana[] newArray(int size) {
            return new Kana[size];
        }
    };
}
