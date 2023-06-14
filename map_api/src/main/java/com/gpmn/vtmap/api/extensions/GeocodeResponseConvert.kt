package com.gpmn.vtmap.api.extensions;

import com.gpmn.vtmap.api.models.map.GeocodingPlace


object GeocodeResponseConvert {
    @JvmStatic
    fun getHouseNumber(results: List<GeocodingPlace>): String? {
        return try {
            val addressComponents = results.first().addressComponents
            addressComponents?.first { it.types?.contains("house_number") == true }?.longName
        } catch (e: Exception) {
            null;
        }
    }

    @JvmStatic
    fun getWard(results: List<GeocodingPlace>): String? {
        return try {
            val addressComponents = results.first().addressComponents
            addressComponents?.first { it.types?.contains("ward") == true }?.longName
        } catch (e: Exception) {
            null;
        }
    }

    @JvmStatic
    fun getDistrict(results: List<GeocodingPlace>): String? {
        return try {
            val addressComponents = results.first().addressComponents
            addressComponents?.first { it.types?.contains("district") == true }?.longName
        } catch (e: Exception) {
            null;
        }
    }

    @JvmStatic
    fun getProvince(results: List<GeocodingPlace>): String? {

        return try {
            val addressComponents = results.first().addressComponents
            addressComponents?.first { it.types?.contains("province") == true }?.longName
        } catch (e: Exception) {
            null;
        }
    }

    @JvmStatic
    fun getCountry(results: List<GeocodingPlace>): String? {
        return try {
            val addressComponents = results.first().addressComponents
            addressComponents?.first { it.types?.contains("country") == true }?.longName
        } catch (e: Exception) {
            null
        }
    }

    @JvmStatic
    fun getAddressString(results: List<GeocodingPlace>): String? {
        return try {
            val addressComponents = results.first().addressComponents
            var result = ""
            if (addressComponents?.first { it.types?.contains("house_number") == true }?.longName != null){
                result += addressComponents.first { it.types?.contains("house_number") == true }.longName + " "
            }
            if (addressComponents?.first { it.types?.contains("route") == true }?.longName != null){
                result += addressComponents.first { it.types?.contains("route") == true }.longName + ", "
            }
            if (addressComponents?.first { it.types?.contains("ward") == true }?.longName != null){
                result += addressComponents.first { it.types?.contains("ward") == true }.longName + ", "
            }
            if (addressComponents?.first { it.types?.contains("district") == true }?.longName != null){
                result += addressComponents.first { it.types?.contains("district") == true }.longName + ", "
            }
            if (addressComponents?.first { it.types?.contains("province") == true }?.longName != null){
                result += addressComponents.first { it.types?.contains("province") == true }.longName + ", "
            }
            if (addressComponents?.first { it.types?.contains("country") == true }?.longName != null){
                result += addressComponents.first { it.types?.contains("country") == true }.longName + ", "
            }
            result
        } catch (e: Exception) {
            null
        }
    }
}
