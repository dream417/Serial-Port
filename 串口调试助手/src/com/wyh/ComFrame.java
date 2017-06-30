package com.wyh;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class ComFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static Toolkit  tk = Toolkit.getDefaultToolkit();
	
	private JPanel mainPanel  = null;//主面板
	
	//串口设置面板
	private Label comSet_NumLabel = new Label("串口号");			//文本-串口号
	private Label comSet_BaudLabel = new Label("波特率");			//文本-串口波特率
	private Label comSet_CheckLabel = new Label("数据位");			//文本-串口校验位
	private Label comSet_DataBitLabel =new Label("校验位");		//文本-串口数据位
	private Label comSet_StopBitLabel = new Label("停止位");		//文本-串口停止位
	private JComboBox comSet_NumComboBox = new JComboBox();			//下拉列表-串口号
	private JComboBox comSet_BaudComboBox = new JComboBox();		//下拉列表-波特率
	private JComboBox comSet_CheckComboBox = new JComboBox();		//下拉列表-校验位
	private JComboBox comSet_DataBitComboBox = new JComboBox();		//下拉列表-数据位
	private JComboBox comSet_StopBitComboBox = new JComboBox();		//下拉列表-停止位
	private JButton comSet_OpenButton = new JButton();				//按钮-打开或关闭串口
	
	//接收设置面板
	private Checkbox receiveSet_TransToFileCheckbox = new Checkbox("接收转向文件...");	//复选框-接收转向文件
	private Checkbox receiveSet_ShowRxTimeCheckbox = new Checkbox("显示接收时间");		//复选框-显示接收时间
	private Checkbox receiveSet_ShowHexCheckbox = new Checkbox("十六进制显示");			//复选框-十六进制显示
	private Checkbox receiveSet_StopShowRXCheckbox= new Checkbox("暂停接收显示");		//复选框-暂停接收显示
	private Label receiveSet_SaveDateLabel = new Label("保存数据");						//可点击文本-保存数据
	private Label receiveSet_ClearRxLabel = new Label("清除显示");						//可点击文本-清除显示
	
	//发送设置面板
	private Checkbox sendSet_EnableFileSourceCheckbox = new Checkbox("启动文件数据源...");	//复选框-启动文件数据源
	private Checkbox sendSet_AutoAttachCheckbox = new Checkbox("自动发送附加位");			//复选框-自动发送附加位
	private Checkbox sendSet_AutoClearAfterSendCheckbox = new Checkbox("发送完自动清空");	//复选框-发送完自动清空
	private Checkbox sendSet_SendHexCheckbox = new Checkbox("按十六进制发送");				//复选框-按16进制发送
	private Checkbox sendSet_EnableCycleSendCheckbox = new Checkbox("数据流循环发送");		//复选框-数据流循环发送
	private Label sendSet_SendIntervalLabel = new Label("发送间隔");						//文本-发送间隔
	private JTextField  sendSet_TimeMsTextField = new JTextField();							//编辑框-发送间隔时间
	private Label sendSet_TimeDegreeLabel = new Label("ms");								//文本-时间单位
	private Label sendSet_OpenFileLabel = new Label("文件载入");							//可点击文本-文件载入
	private Label sendSet_ClearTxLabel = new Label("清除输入");								//可点击文本-清除输入
	
	//接收发送面板
	private JTextArea receiveTextArea = new JTextArea();									//文本框-接收显示框
	private JTextArea sendTextArea = new JTextArea();										//文本框-发送文本框
	private JButton sendButton = new JButton();												//按钮-发送按钮
	
	public ComFrame() {
		// TODO Auto-generated constructor stub
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			initialize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	private void initialize() {
		// TODO Auto-generated method stub
		Dimension size = getToolkit().getScreenSize();// 获得屏幕尺寸
		setLocation((size.width - 640) / 2, (size.height - 480) / 2);// 设置登录窗体
		setSize(640, 480);
		setTitle("串口调试助手");
		setVisible(true);
		setContentPane(getMainPanel());//设置布局
		setResizable(false);
	}

	private JPanel getMainPanel() {
		// TODO Auto-generated method stub
		if(mainPanel == null){
				mainPanel = new JPanel(new BorderLayout());
				
				JPanel operatePanel = new JPanel(new GridBagLayout());					//可操作区域panel,1行2列
				
					JPanel optionsPanel = new JPanel(new GridLayout(3, 1));				//设置区域panel，3行1列
						
						JPanel comSetPanel = new JPanel(new GridLayout(2,1));			//串口设置区域panel，2行1列
							JPanel comParametersPanel = new JPanel(new GridLayout(5, 2));//串口参数
							
						JPanel receiveSetPanel = new JPanel(new GridLayout(5, 1));		//接收设置区域panel，5行1列
							JPanel saveFilePanel =new JPanel(new GridLayout(1, 2));		//保存数据和清除接收区域可点击文本，1行2列
							
						JPanel sendSetPanel	= new JPanel(new GridLayout(7,1));			//发送设置区域Panel，7行1列
							JPanel sendIntervalPanel = new JPanel(new GridLayout(1, 3));
							JPanel openFilePanel = new JPanel(new GridLayout(1, 2)); 	//载入文件和清除发送区域可点击文本，1行2列
							
					
					JPanel receiveSendPanel = new JPanel(new GridLayout(2,1));			//接收发送显示区域Panel，2行1列
				
						JPanel sendAreaPanel = new JPanel(new GridLayout(1,2));			//发送区域Panel，1行2列
				
				JPanel statePanel = new JPanel();					//状态区域panel
			
			receiveTextArea.setBorder(BorderFactory.createLoweredBevelBorder());
			sendTextArea.setBorder(BorderFactory.createLoweredBevelBorder());
				
			comParametersPanel.add(comSet_NumLabel);
			comParametersPanel.add(comSet_NumComboBox);
			comParametersPanel.add(comSet_BaudLabel);
			comParametersPanel.add(comSet_BaudComboBox);
			comParametersPanel.add(comSet_CheckLabel);
			comParametersPanel.add(comSet_CheckComboBox);
			comParametersPanel.add(comSet_DataBitLabel);
			comParametersPanel.add(comSet_DataBitComboBox);
			comParametersPanel.add(comSet_StopBitLabel);
			comParametersPanel.add(comSet_StopBitComboBox);
			
			comSetPanel.add(comParametersPanel);
			comSetPanel.add(comSet_OpenButton);
			
			
			saveFilePanel.add(receiveSet_SaveDateLabel);
			saveFilePanel.add(receiveSet_ClearRxLabel);
			
			receiveSetPanel.add(receiveSet_TransToFileCheckbox);
			receiveSetPanel.add(receiveSet_ShowRxTimeCheckbox);
			receiveSetPanel.add(receiveSet_ShowHexCheckbox);
			receiveSetPanel.add(receiveSet_StopShowRXCheckbox);
			receiveSetPanel.add(saveFilePanel);
			
			
			sendIntervalPanel.add(sendSet_SendIntervalLabel);
			sendIntervalPanel.add(sendSet_TimeMsTextField);
			sendIntervalPanel.add(sendSet_TimeDegreeLabel);
			
			openFilePanel.add(sendSet_OpenFileLabel);
			openFilePanel.add(sendSet_ClearTxLabel);
			
			sendSetPanel.add(sendSet_EnableCycleSendCheckbox);
			sendSetPanel.add(sendSet_AutoAttachCheckbox);
			sendSetPanel.add(sendSet_AutoClearAfterSendCheckbox);
			sendSetPanel.add(sendSet_SendHexCheckbox);
			sendSetPanel.add(sendSet_EnableCycleSendCheckbox);
			sendSetPanel.add(sendIntervalPanel);
			sendSetPanel.add(openFilePanel);
			
			
			optionsPanel.add(comSetPanel);
			optionsPanel.add(receiveSetPanel);
			optionsPanel.add(sendSetPanel);
			
			
			sendAreaPanel.add(sendTextArea);
			sendAreaPanel.add(sendButton);
			
			
			receiveSendPanel.add(receiveTextArea);
			receiveSendPanel.add(sendAreaPanel);
			
			
			GridBagConstraints optionsGridBagConstraints = new GridBagConstraints();// 创建网格限制对象
			optionsGridBagConstraints.gridx = 0;// 组件位于网格的横向索引为4
			optionsGridBagConstraints.fill = GridBagConstraints.BOTH;// 组件垂直扩大以占据空白区域
			optionsGridBagConstraints.weighty = 1.0;// 组件纵向扩大的权重是1.0
			optionsGridBagConstraints.weightx = 1.0;
			optionsGridBagConstraints.gridy = 0;// 组件位于网格的纵向索引为0
			
			GridBagConstraints receiveSendGridBagConstraints = new GridBagConstraints();// 创建网格限制对象
			receiveSendGridBagConstraints.gridx = 1;// 组件位于网格的横向索引为0
			receiveSendGridBagConstraints.fill = GridBagConstraints.BOTH;// 组件水平扩大以占据空白区域
			optionsGridBagConstraints.weighty = 1.0;// 组件纵向扩大的权重是1.0
			receiveSendGridBagConstraints.weightx = 10.0;// 组件横向扩大的权重是1.0
			receiveSendGridBagConstraints.gridy = 0;// 组件位于网格的纵向索引为0
			
			operatePanel.add(optionsPanel,optionsGridBagConstraints);
			operatePanel.add(receiveSendPanel,receiveSendGridBagConstraints);
			
			
			mainPanel.add(operatePanel);
			mainPanel.add(statePanel,BorderLayout.SOUTH);
		}
		
		return mainPanel;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComFrame comFrame = new ComFrame();
	}

}
