package css.cis3334.heartratetracker;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Tom Gibbons in Feb 2017.
 * Edited by Al Zenk
 * For the CIS 3334 class at St. Scholastica
 */

public class HeartRateAdapter  extends ArrayAdapter<HeartRate> {

    private final Context context;      // The activity calling this adapter
    private HeartRateList hrList;       // The object holding the arraylist of hear rates

    /**
     *
     * @param context The activity calling this adapter
     * @param rowLayout The xml file defining the layout for one item or row in the list
     * @param dummyTV the ID for a TextView in the row layout. Not used, but needed by the parent object
     * @param hrList The object holding the arraylist of hear rates
     */
    public HeartRateAdapter(Context context, int rowLayout, int dummyTV, HeartRateList hrList) {
        super(context, rowLayout, dummyTV, hrList.getList());

        this.context = context;
        this.hrList = hrList;
    }

    /**
     * This is called automatically to display each item in the list.
     *    Here you must fill the layout for one row or item in the list
     *
     * @param position index in the list that is being selected
     * @param convertView
     * @param parent The parent layout this list is in
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.heart_rate_row, null);
        //get the heart rate we are displaying
        HeartRate hr = hrList.getHeartRate(position);

        //TextView variable used to access text attribute of heart rates.
        TextView tvPulse=(TextView)view.findViewById(R.id.textViewPulse);

        //Set text to appropriate pulse value.
        tvPulse.setText(tvPulse.getText() + hr.getPulse().toString());

        //Set typeface to bold so that it is easier to read against background.
        tvPulse.setTypeface(null, Typeface.BOLD);

        //Switch statement to determine background color based on heart rate range.
        switch(hr.getRange())
        {
            case 0:

                 tvPulse.setBackgroundColor(ContextCompat.getColor(context, R.color.colorZone1)
                    );

                 break;

            case 1:
                tvPulse.setBackgroundColor(ContextCompat.getColor(context, R.color.colorZone2));

                break;

            case 2:
                tvPulse.setBackgroundColor(ContextCompat.getColor(context, R.color.colorZone3));

                break;

            case 3:

                tvPulse.setBackgroundColor(ContextCompat.getColor(context, R.color.colorZone4));

                break;

            case 4:

                tvPulse.setBackgroundColor(ContextCompat.getColor(context, R.color.colorZone5));

                break;

            case 5:

                tvPulse.setBackgroundColor(ContextCompat.getColor(context, R.color.colorZone6));

                break;

        }




        return(view);
    }

}
