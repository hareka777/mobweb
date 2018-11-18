package hu.bme.aut.simpledrawer;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

import hu.bme.aut.simpledrawer.sqlite.PersistentDataHelper;
import hu.bme.aut.simpledrawer.view.DrawingView;

public class DrawingActivity extends AppCompatActivity {

    private DrawingView canvas;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing);
        canvas = findViewById(R.id.canvas);
        dataHelper = new PersistentDataHelper(this);
        dataHelper.open();
        restorePersistedObjects();
    }
    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        final Toolbar toolbar = findViewById(R.id.toolbar);
        final Menu toolbarMenu = toolbar.getMenu();
        getMenuInflater().inflate(R.menu.menu_toolbar, toolbarMenu);
        for (int i = 0; i < toolbarMenu.size(); i++) {
            final MenuItem menuItem = toolbarMenu.getItem(i);
            menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(final MenuItem item) {
                    return onOptionsItemSelected(item);
                }
            });
            if (menuItem.hasSubMenu()) {
                final SubMenu subMenu = menuItem.getSubMenu();
                for (int j = 0; j < subMenu.size(); j++) {
                    subMenu.getItem(j).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(final MenuItem item) {
                            return onOptionsItemSelected(item);
                        }
                    });
                }
            }
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_style_line:
                canvas.setDrawingStyle(DrawingView.DrawingStyle.LINE);
                item.setChecked(true);
                return true;
            case R.id.menu_style_point:
                canvas.setDrawingStyle(DrawingView.DrawingStyle.POINT);
                item.setChecked(true);
                return true;
            case R.id.menu_delete:
                canvas.clearCanvas();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private PersistentDataHelper dataHelper;



    @Override
    protected void onResume() {
        super.onResume();
        dataHelper.open();
    }

    @Override
    protected void onPause() {
        dataHelper.close();
        super.onPause();
    }

    private void restorePersistedObjects() {
        canvas.restoreObjects(dataHelper.restorePoints(), dataHelper.restoreLines());
    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage(R.string.are_you_sure_want_to_exit)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialogInterface, final int i) {
                        onExit();
                    }
                })
                .setNegativeButton(R.string.cancel, null)
                .show();
    }

    private void onExit() {
        dataHelper.persistPoints(canvas.getPoints());
        dataHelper.persistLines(canvas.getLines());
        dataHelper.close();
        finish();
    }
}
