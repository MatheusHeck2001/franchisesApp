package viewHelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.trabalho1.Login;
import com.example.trabalho1.MainActivity;
import com.example.trabalho1.R;

public class MenuViewHelper {

    private Context context;
    public MenuViewHelper(Context context){
        this.context = context;
    }

    public boolean onCreateOptionsMenu(Activity ac, Menu menu){
        ac.getMenuInflater().inflate(R.menu.menu_main, menu);

        int itemId = View.generateViewId();
        int order = Menu.NONE;
        String menuText = "Home";
        int groupId = Menu.NONE;
        MenuItem item = menu.add(groupId, itemId, order, menuText);
        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent home = new Intent(context, MainActivity.class);
                home.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(home);
                return true;
            }
        });
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item, Activity ac){
        Intent login = new Intent(context, Login.class);
        login.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        switch (item.getItemId()){
            case R.id.actionLogout:
                context.startActivity(login);
        }
        return true;
    }
}
