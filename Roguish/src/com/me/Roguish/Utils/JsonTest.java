package com.me.Roguish.Utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.Base64Coder;
import com.badlogic.gdx.files.FileHandle;

import com.me.Roguish.Roguish;
import com.me.Roguish.Model.*;

public class JsonTest {
	public static void main(String[] args) {
		Json json = new Json();
		ClassCard cCard = new ClassCard("warrior");
		FileHandle warriorFile = Gdx.files.local("Roguish/src/Utils/warrior.json");
		
		String warriorCode = warriorFile.readString();
		String warriorAsText = Base64Coder.decodeString(warriorCode);
		
		cCard = json.fromJson( ClassCard.class, warriorAsText );
		//ClassCard iCard = json.fromJson(com.me.Roguish.Model.ClassCard, );
		
		System.out.println("className:" + cCard.getName());
		
	}
}
