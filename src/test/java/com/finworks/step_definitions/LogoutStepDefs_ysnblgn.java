package com.finworks.step_definitions;

import com.finworks.pages.DashBoardPage_ysnblgn;
import io.cucumber.java.en.And;

/**
 * @author ybilgin
 * @project FinworksErp_Gr19
 */


public class LogoutStepDefs_ysnblgn {

    @And("the user clicks own username on the top bar_YB")
    public void the_user_clicks_own_username_on_the_top_bar_YB() {
        new DashBoardPage_ysnblgn().username.click();
    }

    @And("the user clicks on Log out option_YB")
    public void the_user_clicks_on_Log_out_option_YB() {
        new DashBoardPage_ysnblgn().logout();
    }
}
