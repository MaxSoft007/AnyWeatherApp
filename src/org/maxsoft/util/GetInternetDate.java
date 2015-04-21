package org.maxsoft.util;

import java.util.Date;

import android.os.AsyncTask;
import android.widget.TextView;

public class GetInternetDate extends AsyncTask<TextView[], Object, Date>{
	private TextView[] dateTextView;
	private Date now;
	@Override
	protected Date doInBackground(TextView[]... params) {
		dateTextView = params[0];
		return DateUtils.getInternetDate();
	}

	@Override
	protected void onPostExecute(Date result) {
		if(dateTextView == null){
			now = result;
		}else if(dateTextView.length == 4){
			dateTextView[0].setText(DateUtils.formatDate(DateUtils.getNextDate(result, 1), DateUtils.FMT_DATE_CHINESE));
			dateTextView[1].setText(DateUtils.formatDate(DateUtils.getNextDate(result, 2), DateUtils.FMT_DATE_CHINESE));
			dateTextView[2].setText(DateUtils.formatDate(DateUtils.getNextDate(result, 3), DateUtils.FMT_DATE_CHINESE));
			dateTextView[3].setText(DateUtils.formatDate(DateUtils.getNextDate(result, 4), DateUtils.FMT_DATE_CHINESE));
		}else if(dateTextView.length == 1){
			dateTextView[0].setText(DateUtils.formatDate(result,DateUtils.FMT_DATE_CHINESE));
		}
	}
	public Date getNow() {
		return now;
	}
	public void setNow(Date now) {
		this.now = now;
	}
}
