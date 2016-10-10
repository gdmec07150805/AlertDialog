package cn.edu.gdmec.s07150805.work5;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private AlertDialog dialog;
    private AlertDialog.Builder builder;
    private TextView tView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tView =(TextView)this.findViewById(R.id.textView);
        Button btn1=(Button)this.findViewById(R.id.button1);
        Button btn2=(Button)this.findViewById(R.id.button2);
        Button btn3=(Button)this.findViewById(R.id.button3);
        Button btn4=(Button)this.findViewById(R.id.button4);
        Button btn5=(Button)this.findViewById(R.id.button5);
        Button btn6=(Button)this.findViewById(R.id.button6);
        Button btn7=(Button)this.findViewById(R.id.button7);
        View.OnClickListener listener=new View.OnClickListener() {
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button1:
                        dialog1();
                        break;
                    case R.id.button2:
                        dialog2();
                        break;
                    case R.id.button3:
                        dialog3();
                        break;
                    case R.id.button4:
                        dialog4();
                        break;
                    case R.id.button5:
                        dialog5();
                        break;
                    case R.id.button6:
                        dialog6();
                        break;
                    case R.id.button7:
                        dialog7();
                        break;

                }
            }
        };
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);
        btn5.setOnClickListener(listener);
        btn6.setOnClickListener(listener);
        btn7.setOnClickListener(listener);
    }
    public void dialog1(){
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("提示");
        dialog.setMessage("确认退出吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_alert);
        DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which==DialogInterface.BUTTON_POSITIVE){
                    dialog.dismiss();
                    MainActivity.this.finish();
                }else if(which==DialogInterface.BUTTON_NEGATIVE){
                    dialog.dismiss();
                }
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener);
        dialog.show();
    }
    public void dialog2(){
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("性别");
        dialog.setMessage("你的性别是？");
        dialog.setIcon(android.R.drawable.ic_dialog_alert);
        DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="";
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        str="男";
                        break;
                    case  DialogInterface.BUTTON_NEGATIVE:
                        str="女";
                        break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        str="人妖";
                        break;
                }
                tView.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"男",listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"女",listener);
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"不男不女",listener);
        dialog.show();
    }
    public void dialog3(){
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("请输入");
        dialog.setMessage("你是敬民先生吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_alert);
        final EditText tEdit=new EditText(this);
        dialog.setView(tEdit);
        DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tView.setText("输入的是："+tEdit.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.show();
    }
    public void dialog4() {
        final String item[] = new String[]{"汕头", "广州", "珠海"};
        final boolean Select[] = new boolean[item.length];
        DialogInterface.OnMultiChoiceClickListener mListener = new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                Select[which] = isChecked;
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(item, null, mListener);
        dialog = builder.create();
        dialog.setTitle("复选框");
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选择了：";
                for (int i = 0; i < Select.length; i++) {
                    if (Select[i]) {
                        str += "\n" + item[i];
                    }
                }
                tView.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.show();
    }
    public void dialog5(){
        final String item[]=new String[]{"汕头","广州","珠海"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnClickListener sListenter=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                for(int i=0;i<bSelect.length;i++){
                    bSelect[i]=false;
                    if(bSelect[i]==bSelect[which]){
                        bSelect[i]=true;
                    }
                }
                bSelect[which]=true;
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(item,-1,sListenter);
        dialog=builder.create();
        dialog.setTitle("单选框");
        DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="";
                for(int i=0;i<bSelect.length;i++){
                    if(bSelect[i]){
                        str="\n"+item[i];
                    }
                }
                tView.setText("你选择了："+str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.show();
    }
    public void dialog6(){
        final String item[]=new String[]{"汕头","广州","珠海"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnClickListener sListenter=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选择了："+item[which];
                tView.setText(str);
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setItems(item,sListenter);
        dialog=builder.create();
        dialog.setTitle("列表框");
        DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        };
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener);
        dialog.show();
    }
    public void dialog7(){
        LayoutInflater inflater=getLayoutInflater();
        View layout=inflater.inflate(R.layout.diydialog,null);
        final EditText tEdit=(EditText)layout.findViewById(R.id.editText1);
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("自定义布局");
        dialog.setView(layout);
        DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tView.setText("输入的是："+tEdit.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener);
        dialog.show();
    }
}
