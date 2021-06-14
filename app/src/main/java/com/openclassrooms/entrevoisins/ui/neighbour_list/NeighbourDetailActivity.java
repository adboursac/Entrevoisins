package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NeighbourDetailActivity extends AppCompatActivity {

    public static final String NEIGHBOUR_ID = "NEIGHBOUR_ID";

    @BindView(R.id.imageView)
    ImageView mImageView;
    @BindView(R.id.imageName)
    TextView mImageName;
    @BindView(R.id.detailName)
    TextView mDetailName;
    @BindView(R.id.detailAddress)
    TextView mDetailAddress;
    @BindView(R.id.detailPhoneNumber)
    TextView mDetailPhoneNumber;
    @BindView(R.id.detailSocialMedia)
    TextView mDetailSocialMedia;
    @BindView(R.id.aboutDescription)
    TextView mAboutDescription;
    @BindView(R.id.backButton)
    ImageButton mBackButton;
    @BindView(R.id.favoriteButton)
    ImageButton mFavoriteButton;


    private NeighbourApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neighbour_detail);
        ButterKnife.bind(this);
        mApiService = DI.getNeighbourApiService();
        mBackButton.setOnClickListener(v -> onBackPressed());

        Intent intent = getIntent();
        long neighbourId = intent.getLongExtra(NEIGHBOUR_ID,0);
        Neighbour neighbour = mApiService.getNeighbour(neighbourId);

        Glide.with(this).load(neighbour.getAvatarUrl()).into(mImageView);
        mImageName.setText(neighbour.getName());
        mDetailName.setText(neighbour.getName());
        mDetailAddress.setText(neighbour.getAddress());
        mDetailPhoneNumber.setText(neighbour.getPhoneNumber());
        mDetailSocialMedia.setText(neighbour.getSocialMediaUrl());
        mAboutDescription.setText(neighbour.getAboutMe());
        mFavoriteButton.setImageResource(neighbour.getFavorite() ? R.drawable.ic_star_white_24dp : R.drawable.ic_star_border_white_24dp);

        mFavoriteButton.setOnClickListener(v -> ((FloatingActionButton) v).setImageResource(
            mApiService.toggleFavoriteStatus(neighbourId) ? R.drawable.ic_star_white_24dp : R.drawable.ic_star_border_white_24dp
        ));
    }

    /**
     * Used to navigate to this activity
     * @param context The context of the caller
     * @param neighbourId the id
     */
    public static void navigate(Context context, long neighbourId) {
        Intent intent = new Intent(context, NeighbourDetailActivity.class);
        intent.putExtra(NEIGHBOUR_ID, neighbourId);
        ActivityCompat.startActivity(context, intent, null);
    }
}
