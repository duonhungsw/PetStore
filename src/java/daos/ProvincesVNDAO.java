package daos;

import java.util.ArrayList;
import java.util.List;
import model.Provinces;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Administrative_regions;
import model.Administrative_units;
import model.Districts;
import model.Wards;

public class ProvincesVNDAO extends DBContext {

    public List<Provinces> getAllProvinces() {
        List<Provinces> list = new ArrayList<>();
        String sql = "SELECT [code]\n"
                + "      ,[name]\n"
                + "      ,[name_en]\n"
                + "      ,[full_name]\n"
                + "      ,[full_name_en]\n"
                + "      ,[code_name]\n"
                + "      ,[administrative_unit_id]\n"
                + "      ,[administrative_region_id]\n"
                + "  FROM [dbo].[provinces]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Provinces p = new Provinces();
                p.setCode(rs.getString(1));
                p.setName(rs.getString(2));
                p.setName_en(rs.getString(3));
                p.setFull_name(rs.getString(4));
                p.setFull_name_en(rs.getString(5));
                p.setCode_name(rs.getString(6));
                Administrative_units unit = getUnitsById(rs.getInt(7));
                p.setAdministrative_units(unit);
                Administrative_regions region = getRegionsById(rs.getInt(8));
                p.setAdministrative_regions(region);
                list.add(p);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Administrative_units getUnitsById(int id) {
        String sql = "SELECT [id]\n"
                + "      ,[full_name]\n"
                + "      ,[full_name_en]\n"
                + "      ,[short_name]\n"
                + "      ,[short_name_en]\n"
                + "      ,[code_name]\n"
                + "      ,[code_name_en]\n"
                + "  FROM [dbo].[administrative_units]\n"
                + "  where id =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Administrative_units unit = new Administrative_units();
                unit.setId(rs.getInt(1));
                unit.setFull_name(rs.getString(2));
                unit.setFull_name_en(rs.getString(3));
                unit.setShort_name(rs.getString(4));
                unit.setShort_name_en(rs.getString(5));
                unit.setCode_name(rs.getString(6));
                unit.setCode_name_en(rs.getString(7));

                return unit;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Administrative_regions getRegionsById(int id) {

        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "      ,[name_en]\n"
                + "      ,[code_name]\n"
                + "      ,[code_name_en]\n"
                + "  FROM [dbo].[administrative_regions]\n"
                + "  where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Administrative_regions region = new Administrative_regions();
                region.setId(rs.getInt(1));
                region.setName(rs.getString(2));
                region.setName_en(rs.getString(3));
                region.setCode_name(rs.getString(4));
                region.setCode_name_en(rs.getString(5));
                return region;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Provinces getProvincesById(String code) {

        String sql = "SELECT [code]\n"
                + "      ,[name]\n"
                + "      ,[name_en]\n"
                + "      ,[full_name]\n"
                + "      ,[full_name_en]\n"
                + "      ,[code_name]\n"
                + "      ,[administrative_unit_id]\n"
                + "      ,[administrative_region_id]\n"
                + "  FROM [dbo].[provinces]\n"
                + "  where code = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, code);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Provinces p = new Provinces();
                p.setCode(rs.getString(1));
                p.setName(rs.getString(2));
                p.setName_en(rs.getString(3));
                p.setFull_name(rs.getString(4));
                p.setFull_name_en(rs.getString(5));
                p.setCode_name(rs.getString(6));
                Administrative_units unit = getUnitsById(rs.getInt(7));
                p.setAdministrative_units(unit);
                Administrative_regions region = getRegionsById(rs.getInt(8));
                p.setAdministrative_regions(region);
                return p;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Districts getDistrictsById(String code) {

        String sql = "SELECT [code]\n"
                + "      ,[name]\n"
                + "      ,[name_en]\n"
                + "      ,[full_name]\n"
                + "      ,[full_name_en]\n"
                + "      ,[code_name]\n"
                + "      ,[province_code]\n"
                + "      ,[administrative_unit_id]\n"
                + "  FROM [dbo].[districts]\n"
                + "  where province_code = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, code);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Districts districts = new Districts();
                districts.setCode(rs.getString(1));
                districts.setName(rs.getString(2));
                districts.setName_en(rs.getString(3));
                districts.setFull_name(rs.getString(4));
                districts.setFull_name_en(rs.getString(5));
                districts.setCode_name(rs.getString(6));
                Provinces p = getProvincesById(rs.getString(7));
                districts.setProvinces(p);
                Administrative_units unit = getUnitsById(rs.getInt(8));
                districts.setAdministrative_units(unit);

                return districts;
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public Districts getDistrict(String code) {
        String sql = "SELECT [code]\n"
                + "      ,[name]\n"
                + "      ,[name_en]\n"
                + "      ,[full_name]\n"
                + "      ,[full_name_en]\n"
                + "      ,[code_name]\n"
                + "      ,[province_code]\n"
                + "      ,[administrative_unit_id]\n"
                + "  FROM [dbo].[districts]\n"
                + "  where code = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, code);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Districts districts = new Districts();
                districts.setCode(rs.getString(1));
                districts.setName(rs.getString(2));
                districts.setName_en(rs.getString(3));
                districts.setFull_name(rs.getString(4));
                districts.setFull_name_en(rs.getString(5));
                districts.setCode_name(rs.getString(6));
                Provinces p = getProvincesById(rs.getString(7));
                districts.setProvinces(p);
                Administrative_units unit = getUnitsById(rs.getInt(8));
                districts.setAdministrative_units(unit);

                return districts;
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public Wards getWard(String code) {
        String sql = "SELECT [code]\n"
                + "      ,[name]\n"
                + "      ,[name_en]\n"
                + "      ,[full_name]\n"
                + "      ,[full_name_en]\n"
                + "      ,[code_name]\n"
                + "      ,[district_code]\n"
                + "      ,[administrative_unit_id]\n"
                + "  FROM [dbo].[wards]\n"
                + "  where [code] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, code);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Wards wards = new Wards();
                wards.setCode(rs.getString(1));
                wards.setName(rs.getString(2));
                wards.setName_en(rs.getString(3));
                wards.setFull_name(rs.getString(4));
                wards.setFull_name_en(rs.getString(5));
                wards.setCode_name(rs.getString(6));
                Districts districts = getDistrictsById(rs.getString(7));
                wards.setDistricts(districts);
                Administrative_units unit = getUnitsById(rs.getInt(8));
                wards.setAdministrative_units(unit);

                return wards;

            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Districts> getDistrictsByProvincesId(String province_code) {
        List<Districts> list = new ArrayList<>();
        String sql = "SELECT [code]\n"
                + "      ,[name]\n"
                + "      ,[name_en]\n"
                + "      ,[full_name]\n"
                + "      ,[full_name_en]\n"
                + "      ,[code_name]\n"
                + "      ,[province_code]\n"
                + "      ,[administrative_unit_id]\n"
                + "  FROM [dbo].[districts]\n"
                + "  where province_code = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, province_code);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Districts districts = new Districts();
                districts.setCode(rs.getString(1));
                districts.setName(rs.getString(2));
                districts.setName_en(rs.getString(3));
                districts.setFull_name(rs.getString(4));
                districts.setFull_name_en(rs.getString(5));
                districts.setCode_name(rs.getString(6));
                Provinces p = getProvincesById(rs.getString(7));
                districts.setProvinces(p);
                Administrative_units unit = getUnitsById(rs.getInt(8));
                districts.setAdministrative_units(unit);

                list.add(districts);

            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Wards> getWardsBydistrictId(String district_code) {
        List<Wards> list = new ArrayList<>();
        String sql = "SELECT [code]\n"
                + "      ,[name]\n"
                + "      ,[name_en]\n"
                + "      ,[full_name]\n"
                + "      ,[full_name_en]\n"
                + "      ,[code_name]\n"
                + "      ,[district_code]\n"
                + "      ,[administrative_unit_id]\n"
                + "  FROM [dbo].[wards]\n"
                + "  where [district_code] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, district_code);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Wards wards = new Wards();
                wards.setCode(rs.getString(1));
                wards.setName(rs.getString(2));
                wards.setName_en(rs.getString(3));
                wards.setFull_name(rs.getString(4));
                wards.setFull_name_en(rs.getString(5));
                wards.setCode_name(rs.getString(6));
                Districts districts = getDistrictsById(rs.getString(7));
                wards.setDistricts(districts);
                Administrative_units unit = getUnitsById(rs.getInt(8));
                wards.setAdministrative_units(unit);

                list.add(wards);

            }
        } catch (Exception e) {
        }
        return list;
    }
    
    
    public static void main(String[] args) {
        ProvincesVNDAO dao = new ProvincesVNDAO();
        Wards dis = dao.getWard("19231");
        System.out.println(dis.toString());
    }
}
