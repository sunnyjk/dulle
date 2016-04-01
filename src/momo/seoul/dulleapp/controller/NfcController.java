package momo.seoul.dulleapp.controller;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.tech.NfcA;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;

public class NfcController {
	
	Context mCtx;
	
	public NfcController(Context ctx){
		this.mCtx = ctx;
	}

	/**
	 * Related with NFC Tag
	 */

	private NfcAdapter mAdapter;
	private String[][] mTechLists;

	private int stamp_id;

	
	/** NFC 관련 */
	
	public boolean checkNfcAdapter(){
		mAdapter = NfcAdapter.getDefaultAdapter(mCtx);
		if (mAdapter == null) {
			System.out.println("지원하지 않는 기기입니다.");
			return false;
		}	
		return true;		
	}
	
	public void nfcAlarmToTurnOn(){
		if(!mAdapter.isEnabled()){
			AlertDialog.Builder ad = new AlertDialog.Builder(mCtx);
			ad.setTitle("NFC 알림");
			ad.setMessage("스탬프북 이용에 필요한 NFC 기능을 사용하시겠습니까?");
			ad.setPositiveButton("OK", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					//startActivity(new Intent(android.provider.Settings.ACTION_NFC_SETTINGS));
					
				}
			}).setNegativeButton("NO", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					
				}
			});
			ad.create();
			ad.show();		
	}
	
	
	}
	
	
	public void getNfcData(Intent intent){
		
		mTechLists = new String[][] { new String[] { NfcA.class.getName() } };
		
		if (intent != null) {
			String action = intent.getAction();

			if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action)
					|| NfcAdapter.ACTION_TECH_DISCOVERED.equals(action)
					|| NfcAdapter.ACTION_TAG_DISCOVERED.equals(action)) {

				Parcelable[] rawMsgs = intent
						.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);

				NdefMessage[] msgs;
				if (rawMsgs != null) {
					msgs = new NdefMessage[rawMsgs.length];
					for (int i = 0; i < rawMsgs.length; i++) {
						msgs[i] = (NdefMessage) rawMsgs[i];
					}

				} else {
					byte[] empty = new byte[] {};
					NdefRecord record = new NdefRecord(NdefRecord.TNF_UNKNOWN,
							empty, empty, empty);
					NdefMessage msg = new NdefMessage(
							new NdefRecord[] { record });
					msgs = new NdefMessage[] { msg };
				}

				doAction(msgs);
			}
		}

	}

	private void doAction(NdefMessage[] msgs) {

		String payload = new String(msgs[0].getRecords()[0].getPayload());

		if (payload.startsWith("stamp")) {

			stamp_id = Integer.valueOf(payload.split(":")[1]);

			if (stamp_id != 0) {
				
				new StampController(mCtx).saveStamp(stamp_id);
				
				// 화면 이동이 필요하다면 추가해주기!
			}

		}

	}
}
