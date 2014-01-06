package com.androidtraining.gettingstarted.fragments;

import com.androidtraining.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
/** This is a fragment class, showing article content.
 * 
 * @author rafalniski
 *
 */
public class ArticleFragment extends Fragment {
	final static String ARG_POSITION = "position";
	int mCurrentPosition = -1;
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.article_view, container,false);
	}
	
	public void updateArticleView(int position) {
			/** Filling in proper article content with TextView
			 *  Saving position of current article.
			 **/
	        TextView article = (TextView) getActivity().findViewById(R.id.article);
	        article.setText(Ipsum.Articles[position]);
	        mCurrentPosition = position;
	}
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		/** Save the current article selection in case we need to recreate the fragment **/
		outState.putInt(ARG_POSITION, mCurrentPosition);
	}
	/** During startup, check if there are arguments passed to the fragment.
     *  onStart is a good place to do this because the layout has already been
     *  applied to the fragment at this point so we can safely call the method
     *  below that sets the article text.
     */
	@Override
    public void onStart() {
        super.onStart();
        Bundle args = getArguments();
        if (args != null) {
        	/** Set article based on argument passed in **/
            updateArticleView(args.getInt(ARG_POSITION));
        } else if (mCurrentPosition != -1) {
            /** Set article based on saved instance state defined during onCreateView **/
            updateArticleView(mCurrentPosition);
        }
    }
}
