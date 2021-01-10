import { useNavigation } from "@react-navigation/native";
import React from "react";
import { StyleSheet, Text, View, Image } from "react-native";
import { TouchableWithoutFeedback } from "react-native-gesture-handler";

export default function Header() {
  const navigation = useNavigation();

  const handleOnPress = () => {
    navigation.navigate("Home");
  };

  return (
    <TouchableWithoutFeedback onPress={handleOnPress}>
      <View style={styles.container}>
        <Image source={require("../assets/logo.png")} />
        <Text style={styles.text}>DS Delivery</Text>
      </View>
    </TouchableWithoutFeedback>
  );
}

const styles = StyleSheet.create({
  container: {
    backgroundColor: "#DA5C5C",
    height: 90,
    paddingTop: 50,
    flexDirection: "row",
    justifyContent: "center",
  },
  text: {
    fontFamily: "OpenSans_700Bold",
    fontSize: 18,
    lineHeight: 25,
    // em para px valor em * 16
    letterSpacing: -0.24,
    color: "#FFF",
    marginLeft: 15,
  },
});
