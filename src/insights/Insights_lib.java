package insights;

import com.ibm.watson.developer_cloud.personality_insights.v3.PersonalityInsights;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.ContentItem.Language;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Profile;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.ProfileOptions;

public class Insights_lib {
	//フィールド
	PersonalityInsights service;
	ProfileOptions options = null;

	//コンストラクタ
	public Insights_lib(){
		service = new PersonalityInsights("2016-10-19");
	    service.setUsernameAndPassword("J16014", "J16014");
	}

	public Profile getProfile(String text){
		options = new ProfileOptions.Builder()
			    //.contentLanguage(Language.JA) //日本語入力
				.acceptLanguage(Language.JA)  //日本語出力
			    .text(text)
			    .build();

		Profile profile = service.profile(options).execute();
		return profile;
	}
}
