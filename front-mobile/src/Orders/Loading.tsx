import React from "react";
import { View } from "react-native";
import Loading from "./loading.json";
import LottieView from "lottie-react-native";

export default () => {
  return (
    <View
      style={{
        justifyContent: "center",
        alignItems: "center",
      }}
    >
      <LottieView
        style={{
          width: 500,
          height: 500,
        }}
        resizeMode="contain"
        autoPlay
        loop
        source={Loading}
      />
    </View>
  );
};
