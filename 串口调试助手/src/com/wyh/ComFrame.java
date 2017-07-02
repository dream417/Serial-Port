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
import javax.swing.SpringLayout.Constraints;
import javax.swing.UIManager;

public class ComFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static Toolkit  tk = Toolkit.getDefaultToolkit();
	
	private JPanel mainPanel  = null;//�����
	
	//�����������
	private Label comSet_NumLabel = new Label("���ں�:",Label.RIGHT);			//�ı�-���ں�
	private Label comSet_BaudLabel = new Label("������:",Label.RIGHT);			//�ı�-���ڲ�����
	private Label comSet_CheckLabel = new Label("����λ:",Label.RIGHT);			//�ı�-����У��λ
	private Label comSet_DataBitLabel =new Label("У��λ:",Label.RIGHT);		//�ı�-��������λ
	private Label comSet_StopBitLabel = new Label("ֹͣλ:",Label.RIGHT);		//�ı�-����ֹͣλ
	private JComboBox comSet_NumComboBox = new JComboBox();			//�����б�-���ں�
	private JComboBox comSet_BaudComboBox = new JComboBox();		//�����б�-������
	private JComboBox comSet_CheckComboBox = new JComboBox();		//�����б�-У��λ
	private JComboBox comSet_DataBitComboBox = new JComboBox();		//�����б�-����λ
	private JComboBox comSet_StopBitComboBox = new JComboBox();		//�����б�-ֹͣλ
	private JButton comSet_OpenButton = new JButton("��");				//��ť-�򿪻�رմ���
	
	//�����������
	private Checkbox receiveSet_TransToFileCheckbox = new Checkbox("����ת���ļ�...");	//��ѡ��-����ת���ļ�
	private Checkbox receiveSet_ShowRxTimeCheckbox = new Checkbox("��ʾ����ʱ��");		//��ѡ��-��ʾ����ʱ��
	private Checkbox receiveSet_ShowHexCheckbox = new Checkbox("ʮ��������ʾ");			//��ѡ��-ʮ��������ʾ
	private Checkbox receiveSet_StopShowRXCheckbox= new Checkbox("��ͣ������ʾ");		//��ѡ��-��ͣ������ʾ
	private Label receiveSet_SaveDateLabel = new Label("��������");						//�ɵ���ı�-��������
	private Label receiveSet_ClearRxLabel = new Label("�����ʾ");						//�ɵ���ı�-�����ʾ
	
	//�����������
	private Checkbox sendSet_EnableFileSourceCheckbox = new Checkbox("�����ļ�����Դ...");	//��ѡ��-�����ļ�����Դ
	private Checkbox sendSet_AutoAttachCheckbox = new Checkbox("�Զ����͸���λ");			//��ѡ��-�Զ����͸���λ
	private Checkbox sendSet_AutoClearAfterSendCheckbox = new Checkbox("�������Զ����");	//��ѡ��-�������Զ����
	private Checkbox sendSet_SendHexCheckbox = new Checkbox("��ʮ�����Ʒ���");				//��ѡ��-��16���Ʒ���
	private Checkbox sendSet_EnableCycleSendCheckbox = new Checkbox("������ѭ������");		//��ѡ��-������ѭ������
	private Label sendSet_SendIntervalLabel = new Label("���ͼ��");						//�ı�-���ͼ��
	private JTextField  sendSet_TimeMsTextField = new JTextField();							//�༭��-���ͼ��ʱ��
	private Label sendSet_TimeDegreeLabel = new Label("ms");								//�ı�-ʱ�䵥λ
	private Label sendSet_OpenFileLabel = new Label("�ļ�����");							//�ɵ���ı�-�ļ�����
	private Label sendSet_ClearTxLabel = new Label("�������");								//�ɵ���ı�-�������
	
	//���շ������
	private JTextArea receiveTextArea = new JTextArea();									//�ı���-������ʾ��
	private JTextArea sendTextArea = new JTextArea();										//�ı���-�����ı���
	private JButton sendButton = new JButton();												//��ť-���Ͱ�ť
	
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
		Dimension size = getToolkit().getScreenSize();// �����Ļ�ߴ�
		setLocation((size.width - 800) / 2, (size.height - 600) / 2);// ���õ�¼����
		setSize(800, 600);
		setTitle("���ڵ�������");
		setVisible(true);
		setContentPane(getMainPanel());//���ò���
		setResizable(false);
	}

	private JPanel getMainPanel() {
		// TODO Auto-generated method stub
		if(mainPanel == null){
				mainPanel = new JPanel(new BorderLayout());
				
				JPanel operatePanel = new JPanel(new GridBagLayout());					//�ɲ�������panel,1��2��
				
					JPanel optionsPanel = new JPanel(new GridLayout(3, 1));				//��������panel��3��1��
						
						JPanel comSetPanel = new JPanel(new GridBagLayout());			//������������panel��2��1��
//							JPanel comParametersPanel = new JPanel(new GridBagLayout());//���ڲ���
							
						JPanel receiveSetPanel = new JPanel(new GridLayout(5, 1));		//������������panel��5��1��
							JPanel saveFilePanel =new JPanel(new GridLayout(1, 2));		//�������ݺ������������ɵ���ı���1��2��
							
						JPanel sendSetPanel	= new JPanel(new GridLayout(7,1));			//������������Panel��7��1��
							JPanel sendIntervalPanel = new JPanel(new GridLayout(1, 3));
							JPanel openFilePanel = new JPanel(new GridLayout(1, 2)); 	//�����ļ��������������ɵ���ı���1��2��
							
					
					JPanel receiveSendPanel = new JPanel(new GridLayout(2,1));			//���շ�����ʾ����Panel��2��1��
				
						JPanel sendAreaPanel = new JPanel(new GridLayout(1,2));			//��������Panel��1��2��
				
				JPanel statePanel = new JPanel();					//״̬����panel
			
			receiveTextArea.setBorder(BorderFactory.createLoweredBevelBorder());
			sendTextArea.setBorder(BorderFactory.createLoweredBevelBorder());
			
			JPanel spacePanel = new JPanel();//�հ���
			GridBagConstraints comSet_ParametersConstraints = new GridBagConstraints();// �����������ƶ���
						
			comSet_ParametersConstraints.gridx = 1;// ���λ������ĺ�������Ϊ4
			comSet_ParametersConstraints.gridy = 0;// ���λ���������������Ϊ0
			comSet_ParametersConstraints.weightx = 0.1;
			comSet_ParametersConstraints.weighty = 1;
			comSet_ParametersConstraints.insets = new Insets(2,0,2,0);  //top and bottom padding
			comSet_ParametersConstraints.fill = GridBagConstraints.HORIZONTAL;// �����ֱ������ռ�ݿհ�����
			comSetPanel.add(comSet_NumLabel,comSet_ParametersConstraints);
			
			comSet_ParametersConstraints.gridy = 1;// ���λ���������������Ϊ0
			comSetPanel.add(comSet_BaudLabel,comSet_ParametersConstraints);
			
			comSet_ParametersConstraints.gridy = 2;// ���λ���������������Ϊ0
			comSetPanel.add(comSet_CheckLabel,comSet_ParametersConstraints);
			
			comSet_ParametersConstraints.gridy = 3;// ���λ���������������Ϊ0
			comSetPanel.add(comSet_DataBitLabel,comSet_ParametersConstraints);
			
			comSet_ParametersConstraints.gridy = 4;// ���λ���������������Ϊ0
			comSetPanel.add(comSet_StopBitLabel,comSet_ParametersConstraints);
		
			
			comSet_ParametersConstraints.gridx = 2;// ���λ������ĺ�������Ϊ4
			comSet_ParametersConstraints.gridy = 0;// ���λ���������������Ϊ0
			comSet_ParametersConstraints.weightx = 1.2;
			comSetPanel.add(comSet_NumComboBox,comSet_ParametersConstraints);
						
			comSet_ParametersConstraints.gridy = 1;// ���λ���������������Ϊ0
			comSetPanel.add(comSet_BaudComboBox,comSet_ParametersConstraints);
						
			comSet_ParametersConstraints.gridy = 2;// ���λ���������������Ϊ0
			comSetPanel.add(comSet_CheckComboBox,comSet_ParametersConstraints);
						
			comSet_ParametersConstraints.gridy = 3;// ���λ���������������Ϊ0
			comSetPanel.add(comSet_DataBitComboBox,comSet_ParametersConstraints);
				
			comSet_ParametersConstraints.gridy = 4;// ���λ���������������Ϊ0
			comSetPanel.add(comSet_StopBitComboBox,comSet_ParametersConstraints);
			
			comSet_ParametersConstraints.gridx = 3;// ���λ������ĺ�������Ϊ4
			comSet_ParametersConstraints.gridy = 0;// ���λ���������������Ϊ0
			comSet_ParametersConstraints.weightx = 0.1;
			comSetPanel.add(spacePanel,comSet_ParametersConstraints);
			
			comSet_ParametersConstraints.gridx = 2;// ���λ������ĺ�������Ϊ4
			comSet_ParametersConstraints.gridy = 5;// ���λ���������������Ϊ0
			comSet_ParametersConstraints.weightx = 1.2;
			comSetPanel.add(comSet_OpenButton,comSet_ParametersConstraints);
			
			
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
			
			
			GridBagConstraints optionsGridBagConstraints = new GridBagConstraints();// �����������ƶ���
			optionsGridBagConstraints.gridx = 0;// ���λ������ĺ�������Ϊ4
			optionsGridBagConstraints.fill = GridBagConstraints.BOTH;// �����ֱ������ռ�ݿհ�����
			optionsGridBagConstraints.weightx = 0.1;
			optionsGridBagConstraints.gridy = 0;// ���λ���������������Ϊ0
			
			GridBagConstraints receiveSendGridBagConstraints = new GridBagConstraints();// �����������ƶ���
			receiveSendGridBagConstraints.gridx = 1;// ���λ������ĺ�������Ϊ0
			receiveSendGridBagConstraints.fill = GridBagConstraints.BOTH;// ���ˮƽ������ռ�ݿհ�����
			receiveSendGridBagConstraints.weightx = 10.0;// ������������Ȩ����1.0
			receiveSendGridBagConstraints.gridy = 0;// ���λ���������������Ϊ0
			
			operatePanel.add(optionsPanel,optionsGridBagConstraints);
			operatePanel.add(receiveSendPanel,receiveSendGridBagConstraints);
			
			
			mainPanel.add(operatePanel);
//			mainPanel.add(statePanel,BorderLayout.SOUTH);
		}
		
		return mainPanel;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComFrame comFrame = new ComFrame();
	}

}
