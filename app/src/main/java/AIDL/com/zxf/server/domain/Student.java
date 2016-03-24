package AIDL.com.zxf.server.domain;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {
	public int no;
	public String name;

	
	
	public Student(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	public Student(Parcel in) {
		// TODO Auto-generated constructor stub
		no = in.readInt();
		name = in.readString();
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeInt(no);
		dest.writeString(name);
	}

	public static final Creator<Student> CREATOR = new Creator<Student>() {
		public Student createFromParcel(Parcel in) {
			return new Student(in);
		}

		public Student[] newArray(int size) {
			return new Student[size];
		}
	};

}
